package com.example.final_work.controller.backend;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.support.odps.udf.CodecCheck;
import com.example.final_work.pojo.*;
import com.example.final_work.service.backend.*;
import com.example.final_work.service.developer.*;
import com.example.final_work.tools.Constants;
import com.example.final_work.tools.PageSupport;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sun.org.apache.xpath.internal.operations.Mod;
import javafx.scene.chart.ValueAxis;
import org.apache.commons.io.FilenameUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.jws.WebParam;
import javax.management.modelmbean.ModelMBeanOperationInfo;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.example.final_work.controller.backend.UserLoginController.user_id;

@Controller
@RequestMapping(value="/manager2/backend/app")
public class AppCheckController {
	private Logger logger = Logger.getLogger(AppCheckController.class);
	@Resource
	private AdPromotionService adPromotionService;
	@Resource
    private DictionaryService dictionaryService;
	@Resource
	private BackendUserService backendUserService;
	@Resource
	private AppService appService;
	@Resource
	private AppVersionService appVersionService;
	@Resource 
	private DataDictionaryService dataDictionaryService;
	@Resource 
	private AppCategoryService appCategoryService;
	@Resource
	private DevUserService devUserService;
    @Resource
    private CategoryService categoryService;
	@RequestMapping(value="/list")
	public String getAppInfoList(Model model,HttpSession session,
								 @RequestParam(required=true,defaultValue="1") Integer pageNow,
								 @RequestParam(required=false,defaultValue="5") Integer pageSize1,
								 @RequestParam(value="querySoftwareName",required=false) String querySoftwareName,
								 @RequestParam(value="queryCategoryLevel1",required=false) String _queryCategoryLevel1,
								 @RequestParam(value="queryCategoryLevel2",required=false) String _queryCategoryLevel2,
								 @RequestParam(value="queryCategoryLevel3",required=false) String _queryCategoryLevel3,
								 @RequestParam(value="queryFlatformId",required=false) String _queryFlatformId,
								 @RequestParam(value="pageIndex",required=false) String pageIndex){
        PageHelper.startPage(pageNow,pageSize1);
		logger.info("getAppInfoList -- > querySoftwareName: " + querySoftwareName);
		logger.info("getAppInfoList -- > queryCategoryLevel1: " + _queryCategoryLevel1);
		logger.info("getAppInfoList -- > queryCategoryLevel2: " + _queryCategoryLevel2);
		logger.info("getAppInfoList -- > queryCategoryLevel3: " + _queryCategoryLevel3);
		logger.info("getAppInfoList -- > queryFlatformId: " + _queryFlatformId);
		logger.info("getAppInfoList -- > pageIndex: " + pageIndex);

		List<AppInfo> appInfoList = null;
		List<DataDictionary> flatFormList = null;
		List<AppCategory> categoryLevel1List = null;//列出一级分类列表，注：二级和三级分类列表通过异步ajax获取
		List<AppCategory> categoryLevel2List = null;
		List<AppCategory> categoryLevel3List = null;
		//页面容量
		int pageSize = Constants.pageSize;
		//当前页码
		Integer currentPageNo = 1;
		if(pageIndex != null){
			try{
				currentPageNo = Integer.valueOf(pageIndex);
			}catch (NumberFormatException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		Integer queryCategoryLevel1 = null;
		if(_queryCategoryLevel1 != null && !_queryCategoryLevel1.equals("")){
			queryCategoryLevel1 = Integer.parseInt(_queryCategoryLevel1);
		}
		Integer queryCategoryLevel2 = null;
		if(_queryCategoryLevel2 != null && !_queryCategoryLevel2.equals("")){
			queryCategoryLevel2 = Integer.parseInt(_queryCategoryLevel2);
		}
		Integer queryCategoryLevel3 = null;
		if(_queryCategoryLevel3 != null && !_queryCategoryLevel3.equals("")){
			queryCategoryLevel3 = Integer.parseInt(_queryCategoryLevel3);
		}
		Integer queryFlatformId = null;
		if(_queryFlatformId != null && !_queryFlatformId.equals("")){
			queryFlatformId = Integer.parseInt(_queryFlatformId);
		}//总数量（表）
		int totalCount = 0;
		try {
			totalCount = appService.getAppInfoCount(querySoftwareName, queryCategoryLevel1, queryCategoryLevel2, queryCategoryLevel3, queryFlatformId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//总页数
		PageSupport pages = new PageSupport();
		pages.setCurrentPageNo(currentPageNo);
		pages.setPageSize(pageSize);
		pages.setTotalCount(totalCount);

		int totalPageCount = pages.getTotalPageCount();
		//控制首页和尾页
		if(currentPageNo < 1){
			currentPageNo = 1;
		}else if(currentPageNo > totalPageCount){
			currentPageNo = totalPageCount;
		}
		try {
			appInfoList = appService.getAppInfoList(querySoftwareName, queryCategoryLevel1, queryCategoryLevel2, queryCategoryLevel3, queryFlatformId, currentPageNo, pageSize);
			flatFormList = this.getDataDictionaryList("APP_FLATFORM");
			categoryLevel1List = appCategoryService.getAppCategoryListByParentId(null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        PageInfo<AppInfo> pageInfo = new PageInfo<>(appInfoList);
        model.addAttribute("pageInfo",pageInfo);
		model.addAttribute("appInfoList", appInfoList);
		model.addAttribute("flatFormList", flatFormList);
		model.addAttribute("categoryLevel1List", categoryLevel1List);
		model.addAttribute("pages", pages);
		model.addAttribute("querySoftwareName", querySoftwareName);
		model.addAttribute("queryCategoryLevel1", queryCategoryLevel1);
		model.addAttribute("queryCategoryLevel2", queryCategoryLevel2);
		model.addAttribute("queryCategoryLevel3", queryCategoryLevel3);
		model.addAttribute("queryFlatformId", queryFlatformId);

		//二级分类列表和三级分类列表---回显
		if(queryCategoryLevel2 != null && !queryCategoryLevel2.equals("")){
			categoryLevel2List = getCategoryList(queryCategoryLevel1.toString());
			model.addAttribute("categoryLevel2List", categoryLevel2List);
		}
		if(queryCategoryLevel3 != null && !queryCategoryLevel3.equals("")){
			categoryLevel3List = getCategoryList(queryCategoryLevel2.toString());
			model.addAttribute("categoryLevel3List", categoryLevel3List);
		}
		return "backend/applist";
	}
	
	public List<DataDictionary> getDataDictionaryList(String typeCode){
		List<DataDictionary> dataDictionaryList = null;
		try {
			dataDictionaryList = dataDictionaryService.getDataDictionaryList(typeCode);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dataDictionaryList;
	}
	
	public List<AppCategory> getCategoryList (String pid){
		List<AppCategory> categoryLevelList = null;
		try {
			categoryLevelList = appCategoryService.getAppCategoryListByParentId(pid==null?null:Integer.parseInt(pid));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return categoryLevelList;
	}
	
	/**
	 * 根据parentId查询出相应的分类级别列表
	 * @param pid
	 * @return
	 */
	@RequestMapping(value="/categorylevellist.json",method=RequestMethod.GET)
	@ResponseBody
	public List<AppCategory> getAppCategoryList (@RequestParam String pid){
		logger.debug("getAppCategoryList pid ============ " + pid);
		if(pid.equals("")) pid = null;
		return getCategoryList(pid);
	}
	
	
	/**
	 * 跳转到APP信息审核页面
	 * @param appId
	 * @param versionId
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/check",method=RequestMethod.GET)
	public String check(@RequestParam(value="aid",required=false) String appId,
					   @RequestParam(value="vid",required=false) String versionId,
					   Model model){
		AppInfo appInfo = null;
		AppVersion appVersion = null;
		try {
			appInfo = appService.getAppInfo(Integer.parseInt(appId));
			appVersion = appVersionService.getAppVersionById(Integer.parseInt(versionId));
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute(appVersion);
		model.addAttribute(appInfo);
		return "backend/appcheck";
	}
	@RequestMapping(value="/checksave",method=RequestMethod.POST)
	public String checkSave(AppInfo appInfo){
		logger.debug("appInfo =========== > " + appInfo.getStatus());
		try {
			if(appService.updateSatus(appInfo.getStatus(),appInfo.getId())){
				return "redirect:/manager2/backend/app/list";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "backend/appcheck";
	}

	@RequestMapping(value="/backlist")
	public String getBackInfoList(Model model,HttpSession session,
								 @RequestParam(required=true,defaultValue="1") Integer pageNow,
								 @RequestParam(required=false,defaultValue="5") Integer pageSize1,
								 @RequestParam(value="pageIndex",required=false) String pageIndex){
		PageHelper.startPage(pageNow,pageSize1);
		List<BackendUser> backendUsers = null;
		//页面容量
		int pageSize = Constants.pageSize;
		//当前页码
		Integer currentPageNo = 1;
		if(pageIndex != null){
			try{
				currentPageNo = Integer.valueOf(pageIndex);
			}catch (NumberFormatException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		backendUsers = backendUserService.getUserList();

		//总数量（表）
		int totalCount = 0;
		totalCount = backendUsers.size();
		PageSupport pages = new PageSupport();
		pages.setCurrentPageNo(currentPageNo);
		pages.setPageSize(pageSize);
		pages.setTotalCount(totalCount);
		int totalPageCount = pages.getTotalPageCount();
		//控制首页和尾页
		if(currentPageNo < 1){
			currentPageNo = 1;
		}else if(currentPageNo > totalPageCount){
			currentPageNo = totalPageCount;
		}
		PageInfo<BackendUser> pageInfo = new PageInfo<>(backendUsers);
		model.addAttribute("pageInfo",pageInfo);
		model.addAttribute("backendUsers", backendUsers);
		model.addAttribute("pages", pages);
		return "backend/backLits";
	}

	@RequestMapping(value="/DevStatus")
	public String getBackInfoList1(Model model,HttpSession session,
								  @RequestParam(required=true,defaultValue="1") Integer pageNow,
								  @RequestParam(required=false,defaultValue="5") Integer pageSize1
								  ){
		PageHelper.startPage(pageNow,pageSize1);
		List<DevUser> devList = null;
		//页面容量
		//总页数
		try {
			devList = devUserService.getDevUserList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PageInfo<DevUser> pageInfo = new PageInfo<>(devList);
		model.addAttribute("pageInfo",pageInfo);
		model.addAttribute("devList", devList);
		return "backend/DevStatusModify";
	}

	@RequestMapping(value = "/statusmodify/{id}")
	public String Statusmodify(@PathVariable Integer id){
		int i = devUserService.updateStatus(id);
		return "redirect:/manager2/backend/app/DevStatus";
	}
	@RequestMapping(value = "/statusmodify2/{id}")
	public String Statusmodify2(@PathVariable Integer id){
		int i = devUserService.updateStatus2(id);
		return "redirect:/manager2/backend/app/DevStatus";
	}
	@RequestMapping(value = "/deluser.json")
	@ResponseBody
	public Object deluser(@RequestParam Integer id){
		HashMap<String, String> resultMap = new HashMap<String, String>();
		try {
			if (backendUserService.deldevuser1(id)==1)
				resultMap.put("delResult", "true");
			else
				resultMap.put("delResult", "false");
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return JSONArray.toJSONString(resultMap);
	}

	private Map<String,String> map = new HashMap<>();
	private int userid;
	@RequestMapping(value = "/usermodify/{id}")
	public String usersmodify(@PathVariable Integer id, Model model){
		userid=id;
		BackendUser user = backendUserService.getUser(id);
		model.addAttribute("user",user);
		return "backend/usermodify";
	}



	@RequestMapping(value = "/usermodifysava" ,method=RequestMethod.POST)
	public String usermodifysava(BackendUser backendUser){
		backendUser.setModifyDate(new Date());
		backendUser.setModifyBy(userid);
		backendUser.setId(userid);
		if(backendUserService.modifyuser(backendUser)==1){
			return "redirect:/manager2/backend/app/backlist";
		}
		else
			return "redirect:/manager2/backend/app/usermodify/"+backendUser.getId();
	}

	@RequestMapping( value = "/backuseradd")
	public String backuseradd(Model model){
	    map.clear();
	    model.addAttribute("errorss",map);
		return "backend/addbackuser";
	}


	@RequestMapping( value = "/backuseraddsave",method = RequestMethod.POST)
	public String backuseraddsave(@Valid BackendUser backendUser, BindingResult errors,Model model){
		backendUser.setCreationDate(new Date());
		backendUser.setCreatedBy(user_id);
        List<FieldError> fieldErrors = errors.getFieldErrors();
        map.clear();
        System.out.println(map);
		if (errors.hasErrors()) {
            for (FieldError fieldError : fieldErrors) {
                map.put(fieldError.getField(),fieldError.getDefaultMessage());
                System.out.println(fieldError.getField() + ":" + fieldError.getDefaultMessage());// 获取错误消息的详细内容
            }
            model.addAttribute("errorss",map);
            return "backend/addbackuser";
		}
		else
        {
            if (backendUserService.insertuser(backendUser)==1)
                return "redirect:/manager2/backend/app/backlist";
		    else
                return "backend/addbackuser";
        }



	}

    @RequestMapping(value="/dictionlist")
    public String getAppInfoList(Model model,HttpSession session,
                                 @RequestParam(required=true,defaultValue="1") Integer pageNow,
                                 @RequestParam(required=false,defaultValue="5") Integer pageSize
                                 ){
		PageHelper.startPage(pageNow,pageSize);
        List<DataDictionary> dataDictionaries = null;
        dataDictionaries=dictionaryService.getDictionaryList();
        PageInfo pageInfo=new PageInfo<DataDictionary>(dataDictionaries);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("diclist",dataDictionaries);
        return "backend/dictionary";
    }
    int dicid;
	@RequestMapping(value = "/dictionmodify/{id}")
	public String dictionmodify(Model model,@PathVariable Integer id){
		DataDictionary dataDictionary = dictionaryService.getdatabyid(id);
		dicid=id;
		model.addAttribute("dataDictionary",dataDictionary);
		return "backend/dataModify";
	}

	@RequestMapping(value = "/dictionmodifysave")
	public String dictionmodifysave(DataDictionary dataDictionary){
        dataDictionary.setModifyDate(new Date());
        dataDictionary.setModifyBy(user_id);
        dataDictionary.setId(dicid);
        if (dictionaryService.modifydata(dataDictionary)==1){
        	return "redirect:/manager2/backend/app/dictionlist";
		}
		return "backend/dataModify";
	}

    @RequestMapping(value="/categorylist")
    public String categorylist(Model model,HttpSession session,
                                 @RequestParam(required=true,defaultValue="1") Integer pageNow,
                                 @RequestParam(required=false,defaultValue="5") Integer pageSize
                                ){
		PageHelper.startPage(pageNow,pageSize);
        List<AppCategory> appCategories = null;
        appCategories=categoryService.getAppCategoryList();
		PageInfo pageInfo=new PageInfo<AppCategory>(appCategories);
		model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("appCategories",appCategories);
        return "backend/appCategoryList";
    }

    @RequestMapping(value = "delcat.json")
	@ResponseBody
     public Object  categorydel(@RequestParam Integer id){
        HashMap<String, String> resultMap = new HashMap<String, String>();
        try {
            if(categoryService.deleteappcategory(id)==1)
                resultMap.put("delResult", "true");
            else
                resultMap.put("delResult", "false");
        } catch (NumberFormatException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return JSONArray.toJSONString(resultMap);
    }

    int cateid;
    @RequestMapping(value = "/categorymodify/{id}")
	public String categorymodify(@PathVariable Integer id, Model model){
		AppCategory appCategory=categoryService.getAppCategory(id);
		cateid=id;
		model.addAttribute("appCategory",appCategory);
		return "backend/appCategorymodify";
	}

	@RequestMapping(value = "/categorymodifysave")
	public String categorymodifysave(AppCategory appCategory){
        appCategory.setModifyBy(user_id);
        appCategory.setModifyDate(new Date());
        appCategory.setId(cateid);
        if (categoryService.appcategorymodify(appCategory)==1){
            return "redirect:/manager2/backend/app/categorylist";
        }
        else
            return "backend/appCategorymodify";
	}


    @RequestMapping(value = "/categoryadd")
	public String categoryadd(AppCategory appCategory){
		return "backend/appCategoryAdd";
	}

	@RequestMapping(value = "/categoryaddsave")
	public String categoryaddsave(AppCategory appCategory){
		appCategory.setCreatedBy(user_id);
		appCategory.setCreationDate(new Date());
		if (categoryService.insertcategory(appCategory)==1){
			return "redirect:/manager2/backend/app/categorylist";
		}
		else {
			return "backend/appCategoryAdd";
		}
	}

	@RequestMapping(value="/appADlist1")
	public String appadlist(Model model,HttpSession session,
							   @RequestParam(required=true,defaultValue="1") Integer pageNow,
							   @RequestParam(required=false,defaultValue="5") Integer pageSize
	){
		PageHelper.startPage(pageNow,pageSize);
		List<AdPromotion> adPromotions = null;
		adPromotions=adPromotionService.getAppADinfo();
		PageInfo pageInfo=new PageInfo<AdPromotion>(adPromotions);
		model.addAttribute("pageInfo",pageInfo);
		model.addAttribute("adPromotions",adPromotions);
		return "backend/appADList";
	}

	int appadid;
	@RequestMapping(value = "/appadmodify/{id}")
	public String appadmodify(@PathVariable Integer id,Model model) throws Exception {
    	AdPromotion adPromotion=adPromotionService.getadlistnyid(id);
    	int appid=adPromotion.getAppId();
    	appadid=id;
    	AppInfo appinfoid=appService.getAppInfo(appid);
    	model.addAttribute("adPromotion",adPromotion);
    	model.addAttribute("appinfoid",appinfoid);
    	return "backend/admodify";
	}

    @RequestMapping(value = "/appadmodifysave")
    public String appadmodifysave(AdPromotion adPromotion) throws Exception {
	    adPromotion.setModifyBy(user_id);
	    adPromotion.setModifyDate(new Date());
	    adPromotion.setId(appadid);
	    if (adPromotionService.modifyad(adPromotion)==1)
	        return "redirect:/manager2/backend/app/appADlist1";
        return "backend/admodify";
    }

    @RequestMapping(value ="/appadadd" )
	public String appad(){
		return "backend/appadadd";
	}
	@RequestMapping(value = "/appadaddsave",method = RequestMethod.POST)
	public String appadadd(AdPromotion adPromotion, HttpSession session, HttpServletRequest request,
						   @RequestParam(value="a_logoPicPath",required= false) MultipartFile attach){
		adPromotion.setCreationDate(new Date());
		adPromotion.setCreatedBy(user_id);
		String logoPicPath =  null;
		String logoLocPath =  null;
		if(!attach.isEmpty()){
			String path = "C:\\Users\\MAC\\Desktop\\JAVA-WEB\\uploads\\uploadfiles";
			logger.info("uploadFile path: " + path);
			String oldFileName = attach.getOriginalFilename();//原文件名
			String prefix = FilenameUtils.getExtension(oldFileName);//原文件后缀
			String fileName = adPromotion.getAdPicPath() + ".jpg";//上传LOGO图片命名:apk名称.apk
			File targetFile = new File(path,fileName);
			try { attach.transferTo(targetFile); }
			catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace(); }
			logoPicPath = request.getContextPath()+ "/uploadfiles/" +oldFileName;
			logoLocPath = path+File.separator+oldFileName;
		}
		adPromotion.setAdPicPath(logoPicPath);
		System.out.println(logoLocPath);
		System.out.println(adPromotion);
		if (adPromotionService.insertad(adPromotion)==1)
			return "redirect:/manager2/backend/app/appADlist1";
		return "backend/appadadd";
	}

    @RequestMapping(value = "delappad.json")
    @ResponseBody
    public Object  delappad(@RequestParam Integer id){
        HashMap<String, String> resultMap = new HashMap<String, String>();
        try {
            if(adPromotionService.delappad(id)==1)
                resultMap.put("delResult", "true");
            else
                resultMap.put("delResult", "false");
        } catch (NumberFormatException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return JSONArray.toJSONString(resultMap);
    }

    @RequestMapping(value = "/backlist1")
    public String backlist1(@RequestParam(value="queryUserName",required=false) String queryUserName,
                            @RequestParam(value="pageIndex",required=false) String pageIndex,
                            Model model){
        List<BackendUser> backendUsers = null;
        int pageSize = Constants.pageSize;
        Integer currentPageNo = 1;
        if(pageIndex != null){
            try{
                currentPageNo = Integer.valueOf(pageIndex);
            }catch (NumberFormatException e) {
                // TODO: handle exception
                e.printStackTrace();
            }
        }
        if (queryUserName!=null ||queryUserName.equals(""))
        { backendUsers = backendUserService.backuserfind(queryUserName); }
        else
            backendUsers = backendUserService.getUserList();
        int totalCount = 0;
        totalCount = backendUsers.size();
        PageSupport pages = new PageSupport();
        pages.setCurrentPageNo(currentPageNo);
        pages.setPageSize(pageSize);
        pages.setTotalCount(totalCount);
        int totalPageCount = pages.getTotalPageCount();
        //控制首页和尾页
        if(currentPageNo < 1){
            currentPageNo = 1;
        }else if(currentPageNo > totalPageCount){
            currentPageNo = totalPageCount;
        }
        model.addAttribute("backendUsers", backendUsers);
        model.addAttribute("pages", pages);
        return "backend/backLits";
    }
    @RequestMapping(value="/devfind")
    public String devfind(Model model,HttpSession session,
                                   @RequestParam(required=true,defaultValue="1") Integer pageNow,
                                    @RequestParam(value="queryDevName",required=false) String queryDevName,
                                   @RequestParam(required=false,defaultValue="5") Integer pageSize1
						  ){
        PageHelper.startPage(pageNow,pageSize1);
        List<DevUser> devList = null;
        if (queryDevName!=null || queryDevName.equals("")!=false)
        {
            devList = devUserService.devfind(queryDevName);
        }
        else
            devList = devUserService.getDevUserList();
        //总页数
        PageInfo<DevUser> pageInfo = new PageInfo<>(devList);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("devList", devList);
        return "backend/DevStatusModify";
    }

    @RequestMapping(value="/dictionlist1")
    public String finddata(Model model,HttpSession session,
                           @RequestParam(value="querytypeCode",required=false) String querytypeCode,
                           @RequestParam(value="querytypeName",required=false) String querytypeName,
                           @RequestParam(value="queryvalueName",required=false) String queryvalueName,
                                 @RequestParam(required=true,defaultValue="1") Integer pageNow,
                                 @RequestParam(required=false,defaultValue="5") Integer pageSize
    ){
        PageHelper.startPage(pageNow,pageSize);
        List<DataDictionary> dataDictionaries = null;
		System.out.println(querytypeCode+""+querytypeCode+""+querytypeCode);
        if (querytypeCode.equals("")!=false ||querytypeCode!=null ||
                querytypeName.equals("")!=false ||querytypeName!=null ||
                queryvalueName.equals("")!=false ||queryvalueName!=null )
        {
            DataDictionary dataDictionary=new DataDictionary();
            if (querytypeCode!=null)
                dataDictionary.setTypeCode(querytypeCode);
            if (querytypeName!=null)
            dataDictionary.setTypeName(querytypeName);
            if (queryvalueName!=null)
            dataDictionary.setValueName(queryvalueName);
            dataDictionaries=dictionaryService.finddata(dataDictionary);
        }
        else
            dataDictionaries=dictionaryService.getDictionaryList();
        PageInfo pageInfo=new PageInfo<DataDictionary>(dataDictionaries);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("diclist",dataDictionaries);
        return "backend/dictionary";
    }

    @RequestMapping(value="/categorylist1")
    public String categorylist1(Model model,HttpSession session,
                                @RequestParam(value="querycatcode",required=false) String querycatcode,
                                @RequestParam(value="querycatname",required=false) String querycatname,
                               @RequestParam(required=true,defaultValue="1") Integer pageNow,
                               @RequestParam(required=false,defaultValue="5") Integer pageSize
    ){
        PageHelper.startPage(pageNow,pageSize);
        List<AppCategory> appCategories = null;
        AppCategory appCategory=new AppCategory();
        if (querycatcode!=null || querycatname!=null){
            if (querycatcode!=null)
                appCategory.setCategoryCode(querycatcode);
            if (querycatname!=null)
                appCategory.setCategoryName(querycatname);
            appCategories=categoryService.appcategoryfind(appCategory);
        }
        else
            appCategories=categoryService.getAppCategoryList();
        PageInfo pageInfo=new PageInfo<AppCategory>(appCategories);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("appCategories",appCategories);
        return "backend/appCategoryList";
    }
	@RequestMapping(value="/appADlist11")
	public String getAppADinfofind(Model model,HttpSession session,
							@RequestParam(value="queryadappid",required=false) String querycatcode,
							@RequestParam(value="queryadappname",required=false) String queryadappname,
							@RequestParam(required=true,defaultValue="1") Integer pageNow,
							@RequestParam(required=false,defaultValue="5") Integer pageSize
	){
		PageHelper.startPage(pageNow,pageSize);
		AppInfo appInfo = new AppInfo();

		AdPromotion adPromotion = new AdPromotion();
		List<AdPromotion> adPromotions = null;
		if (querycatcode!=null){
			int a = Integer.valueOf(querycatcode);
			adPromotion.setAppId(a);
			adPromotions = adPromotionService.getAppADinfofind(adPromotion);
		}
		else
			adPromotions=adPromotionService.getAppADinfo();
		PageInfo pageInfo=new PageInfo<AdPromotion>(adPromotions);
		model.addAttribute("pageInfo",pageInfo);
		model.addAttribute("adPromotions",adPromotions);
		return "backend/appADList";
	}

	@RequestMapping(value = "/adddictionary")
    public String adddictionary(){
	    return "backend/dictionaryadd";
    }
    @RequestMapping(value = "/adddictionarysave")
    public String adddictionarysave(DataDictionary dataDictionary){
	    dataDictionary.setCreatedBy(user_id);
	    dataDictionary.setCreationDate(new Date());
	    dictionaryService.insertdata(dataDictionary);
	    return "redirect:/manager2/backend/app/dictionlist";
    }

    @Resource
	private AppInfoService appInfoService;

	@RequestMapping(value="/countbysoftname.json")
	@ResponseBody
	public Object countbysoftname(){
//		logger.debug("delApp appId===================== "+id);
		HashMap<String, List<AppInfo>> resultMap = new HashMap<>();
		List<AppInfo> countbysoftname=null;
		try {
			if (appInfoService.countbysoftname()!=null){
				countbysoftname =appInfoService.countbysoftname();
				resultMap.put("result",countbysoftname);
			}
		}
		catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return JSONArray.toJSONString(resultMap);
	}

	@RequestMapping(value = "/chart")
	public String Chart(){
		return "backend/chatr";
	}
}
