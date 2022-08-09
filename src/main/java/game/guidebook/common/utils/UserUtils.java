package game.guidebook.common.utils;


import game.guidebook.common.SystemConfigUtil;
import game.guidebook.common.security.Digests;
import game.guidebook.constants.SysConstants;
import game.guidebook.domain.User;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

@Component
public class UserUtils
{
//	private static ServiceFactory serviceFactory = ComponentContextLoader.getBean(ServiceFactory.class);
//
//	// ------------------权限缓存存入第三方缓存服务（ehcache、redis等）--------------------------start
//	// 公司cache域
	public static final String CACHE_COMPANY = "cache_company_";

	// public static final String CACHE_COMPANY_BASIC = "cache_company_basic_";
	// public static final String CACHE_COMPANY_BASIC_MAP = "cache_company_map_";

	// 公司权限
	public static final String CACHE_COMPANY_PERMISSION = "company_permission";

	// ------------------权限缓存存入SESSION--------------------------end

	// ------------------权限缓存存入SESSION--------------------------start

	// 用户权限session
	public static final String CACHE_USER_PERMISSION = "user_permission";

	// 用户权限标志session
	public static final String CACHE_USER_PERMISSION_IDENTIFIER = "user_permission_identifier";

	// 用户角色session
	public static final String CACHE_USER_ROLE_LIST = "user_role_list";

	// 用户菜单导航栏session
	public static final String CACHE_USER_NAVIGATION = "user_navigation";

	// 所有权限缓存（超级管理员使用：admin）
	// public static final String CACHE_MENU_ALL_LIST = "all_permission_list";
	// 超级管理员用户名
	// public static final String ADMIN_NAME = SystemConfigUtil.getConfig(SysConstants.ADMIN_USERNAME);//
//	// ------------------权限缓存---------------------------------------end
//
//	/**
//	 * 获取当前用户权限
//	 * @return
//	 */
//	public static List<Menu> getMenuList()
//	{
//		@SuppressWarnings("unchecked")
//		List<Menu> menus = (Vector<Menu>) getSessionCache(CACHE_USER_PERMISSION);
////		System.out.println("getSessionCache(CACHE_USER_PERMISSION) = " + menus);
//		if (menus == null)
//		{
//			User user = getUser();
//			String companyId = user.getCompanyId();
//			//System.out.println("companyId in MenuList = " + companyId);
//			if (user != null)
//			{
//				menus = new Vector<Menu>();
//				if (isSystemAdmin())
//				{
//					//System.out.println("admin 계정일 때 출력 됨 =============================================================================================================");
//					menus.addAll(serviceFactory.getMenuService().findAll());
//					// menus=serviceFactory.getMenuService().findAll();
//				}
//				else
//				{
//					if (companyId != null)
//					{
//						//System.out.println("admin 계정이 아닐 때 출력 됨 =============================================================================================================");
//						menus.addAll(serviceFactory.getMenuService().findAllPermissionByCompanyId(companyId));
//					}
//					else
//					{
//						menus.addAll(serviceFactory.getMenuService().findAllPermissionByUserId(user.getId()));
//					}
//					// menus = serviceFactory.getMenuService().findAllPermissionByUserId(user.getId());
//				}
//				//System.out.println("menus = " + menus);
//				putSessionCache(CACHE_USER_PERMISSION, menus);
//			}
//		}
//		return menus;
//	}
//
//	/**
//	 * 获取当前用户授权导航
//	 * @return
//	 */
//	public static List<Menu> getNavigationMenu()
//	{
//		@SuppressWarnings("unchecked")
//		List<Menu> menus = (Vector<Menu>) getSessionCache(CACHE_USER_NAVIGATION);
//		if (menus == null)
//		{
//			User user = getUser();
//			String companyId = user.getCompanyId();
//			if (user != null)
//			{
//				menus = new Vector<Menu>();
//				if (isSystemAdmin())
//				{
//					menus.addAll(serviceFactory.getMenuService().findAllNavigationMenu());
//					// menus = serviceFactory.getMenuService().findAllNavigationMenu();
//				}
//				else
//				{
//					if (isCompanyAdmin())
//					{
//						menus.addAll(serviceFactory.getMenuService().findAllNavigationMenu(companyId));
//					}
//					else
//					{
//						menus.addAll(serviceFactory.getMenuService().findNavigationMenuByUserId(user.getId()));
//					}
//					// menus = serviceFactory.getMenuService().findNavigationMenuByUserId(user.getId());
//				}
//				putSessionCache(CACHE_USER_NAVIGATION, menus);
//			}
//		}
//		return menus;
//	}
//
//	/**
//	 * 获取当前用户授权角色
//	 * @return
//	 */
//	public static List<Role> getRoleList()
//	{
//		@SuppressWarnings("unchecked")
//		List<Role> roles = (Vector<Role>) getSessionCache(CACHE_USER_ROLE_LIST);
//		if (roles == null)
//		{
//			User user = getUser();
//			if (user != null)
//			{
//				roles = new Vector<Role>();
//				roles.addAll(serviceFactory.getRoleService().findByUserId(getUser().getId()));
//				// roles = serviceFactory.getRoleService().findByUserId(getUser().getId());
//				putSessionCache(CACHE_USER_ROLE_LIST, roles);
//			}
//		}
//		return roles;
//	}
//
//	/**
//	 * 获取当前公司的授权菜单
//	 * @return
//	 */
//	@SuppressWarnings("unchecked")
//	public static List<Menu> getMenuListByCompanyId(String companyId)
//	{
//		List<Menu> menus = null;
//		if (StringUtils.isNotBlank(companyId))
//		{
//			menus = (Vector<Menu>) getCompanyCache(companyId, CACHE_COMPANY_PERMISSION);
//			if (menus == null)
//			{
//				User user = getUser();
//				if (user != null)
//				{
//					menus = new Vector<Menu>();
//					/*
//					 * if (isSystemAdmin()) { menus.addAll(serviceFactory.getMenuService().findAll()); } else {
//					 * menus.addAll(serviceFactory.getMenuService().findAllPermissionByCompanyId(companyId)); }
//					 */
//					// 取公司权限
//					menus.addAll(serviceFactory.getMenuService().findAllPermissionByCompanyId(companyId));
//					putCompanyCacheMap(companyId, CACHE_COMPANY_PERMISSION, menus);
//				}
//			}
//		}
//		return menus;
//	}
//
//	public static void updateUserPermissionIdentifier()
//	{
//		Set<String> permissionSet = new HashSet<String>();
//		if (getUser() != null)
//		{
//			List<Menu> mlist = getMenuList();
//			for (Menu m : mlist)
//			{
//				if (StringUtils.isNotBlank(m.getIdentifier()))
//				{
//					// 添加基于Permission的权限信息
//					for (String permission : StringUtils.split(m.getIdentifier(), ","))
//					{
//						permissionSet.add(permission);
//					}
//				}
//			}
////			System.out.println("permissionSet = " + permissionSet);
//			Objects.requireNonNull(getSession()).removeAttribute(CACHE_USER_PERMISSION_IDENTIFIER);
//			getSession().setAttribute(CACHE_USER_PERMISSION_IDENTIFIER, permissionSet);
//		}
//	}

	@SuppressWarnings("unchecked")
	public static Set<String> getPermissions()
	{
		return (Set<String>) (Objects.requireNonNull(getSession()).getAttribute(CACHE_USER_PERMISSION_IDENTIFIER));
	}

	public static boolean hasPermission(String permission)
	{
		if (StringUtils.isNotBlank(permission))
		{
//			System.out.println("permission = " + permission);
			Set<String> permissions = getPermissions();
//			System.out.println("permissions = " + permissions);
			if (permissions != null)
			{
				return permissions.contains(permission);
			}
		}
		return false;
	}


//	public static List<?> getBasicList(boolean isPublic, String type)
//	{
//		List<Object> list = null;
//		BasicType _type = BasicType.valueOf(type.toUpperCase());
//		if (_type != null)
//		{
//			String companyId = isPublic ? SystemConfigUtil.getInitCompanyId() : getCompanyId();
//			list = (Vector<Object>) (getCompanyCache(companyId, _type.getCacheName()));
//			if (list == null)
//			{
//				list = new Vector<Object>();
//				if (isPublic)
//				{
//					list.addAll(serviceFactory.getCommonService().getCommBasicInfoList(_type));
//					// list = serviceFactory.getCommonService().getCommBasicInfoList(_type);
//				}
//				else
//				{
//					list.addAll(serviceFactory.getCommonService().getBasicInfoList(_type));
//					// list = serviceFactory.getCommonService().getBasicInfoList(_type);
//				}
//
//				putCompanyCacheMap(companyId, _type.getCacheName(), list);
//			}
//		}
//		return list;
//
//	}


//	public static List<?> getPublicBasicList(String type)
//	{
//		return getBasicList(true, type);
//	}
//
//
//	public static List<?> getBasicList(String type)
//	{
//		return getBasicList(false, type);
//	}
//
//
//	public static List<?> getBasicListParam(boolean isPublic, String type, String filed, String values)
//	{
//		List<?> old_list = getBasicList(isPublic, type);
//		if (StringUtils.isBlank(values))
//		{
//			return old_list;
//		}
//		List<String> valuList = Arrays.asList(values.split(","));
//		List<Object> new_list = new ArrayList<Object>();
//		for (Object o : old_list)
//		{
//			if (valuList.contains(Reflections.getFieldValue(o, filed).toString()))
//			{
//				new_list.add(o);
//			}
//		}
//		return new_list;
//	}
//
//	/**
//	 * 获取公共基础类列表(有过滤条件)
//	 * @return
//	 */
//	public static List<?> getPublicBasicListParam(String type, String filed, String values)
//	{
//		return getBasicListParam(true, type, filed, values);
//	}
//
//	/**
//	 * 获取当前基础类列表(有过滤条件)
//	 * @return
//	 */
//	public static List<?> getBasicListParam(String type, String filed, String values)
//	{
//		return getBasicListParam(false, type, filed, values);
//	}
//
//	/**
//	 * 获取基础类MAP
//	 */
//	@SuppressWarnings("unchecked")
//	public static Map<Long, ?> getBasicMap(boolean isPublic, String type)
//	{
//		Map<Long, ?> map = null;
//		BasicType _type = BasicType.valueOf(type.toUpperCase());
//		if (_type != null)
//		{
//			String companyId = isPublic ? SystemConfigUtil.getInitCompanyId() : getCompanyId();
//			String cacheMapKey = _type.getCacheName() + "_map";
//			map = (Map<Long, Object>) (getCompanyCache(companyId, cacheMapKey));
//			if (map == null)
//			{
//				map = ConverterUtils.list2Map(getBasicList(isPublic, type), "id");
//				putCompanyCacheMap(companyId, cacheMapKey, map);
//			}
//		}
//		return map;
//	}
//
//	/**
//	 * 获取公共基础类MAP
//	 */
//	public static Map<Long, ?> getPublicBasicMap(String type)
//	{
//		return getBasicMap(true, type);
//	}
//
//	/**
//	 * 获取当前基础类MAP
//	 */
//	public static Map<Long, ?> getBasicMap(String type)
//	{
//		return getBasicMap(false, type);
//	}
//
//	/**
//	 * 获取基础类对象
//	 */
//	public static Object getBasicInfo(boolean isPublic, String type, Long id)
//	{
//		return getBasicMap(isPublic, type).get(id);
//	}
//
//	/**
//	 * 获取公共基础类对象
//	 */
//	public static Object getPublicBasicInfo(String type, Long id)
//	{
//		return getBasicInfo(true, type, id);
//	}
//
//	/**
//	 * 获取基础类对象
//	 */
//	public static Object getBasicInfo(String type, Long id)
//	{
//		return getBasicInfo(false, type, id);
//	}
//
//	/**
//	 * 获取基础类对象属性
//	 */
//	public static Object getBasicInfoFiledValue(boolean isPublic, String type, Long id, String filedName)
//	{
//		if (getBasicMap(isPublic, type).get(id) != null)
//		{
//			return Reflections.getFieldValue(getBasicMap(isPublic, type).get(id), filedName);
//		}
//		else
//		{
//			return "";
//		}
//	}
//
//	/**
//	 * 获取当前基础类对象属性
//	 */
//	public static Object getPublicBasicInfoFiledValue(String type, Long id, String filedName)
//	{
//		return getBasicInfoFiledValue(true, type, id, filedName);
//	}
//
//	/**
//	 * 获取当前基础类对象属性
//	 */
//	public static Object getBasicInfoFiledValue(String type, Long id, String filedName)
//	{
//		return getBasicInfoFiledValue(false, type, id, filedName);
//	}
//
//	/**
//	 * <pre>
//	 * 清除公司基础资料缓存
//	 * </pre>
//	 */
//	public static void clearCacheBasic(BasicType type)
//	{
//		CacheUtils.remove(CACHE_COMPANY + getCompanyId(), type.getCacheName());
//		CacheUtils.remove(CACHE_COMPANY + getCompanyId(), type.getCacheName() + "_map");
//	}


//	public static void clearCachePermission(String companyId)
//	{
//		clearCompanyCache(companyId, CACHE_COMPANY_PERMISSION);
//	}

//	public static Long getUserId()
//	{
//		return getUser() != null ? getUser().getId() : null;
//	}
//
//	public static String getUserName()
//	{
//		return getUser() != null ? getUser().getName() : null;
//	}


//	public static boolean isSystemAdmin()
//	{
//		String userName = getUserName();
//		if (userName != null)
//		{
//			return userName.equals(SystemConfigUtil.getConfig(SysConstants.ADMIN_USERNAME));
//		}
//		return false;
//	}


	/**
	 * 用户登录
	 * @return
	 */
	public static void login(User user)
	{
		putSessionCache("session_login_user", user);
		putSessionCache("session_login_userId", user.getId());
	}

//	public static void loginout()
//	{
//		// UserUtils.removeSessionCache(SysConstants.SESSION_KEY_LOGIN_USER);
//		// UserUtils.removeSessionCache(SysConstants.SESSION_KEY_LOGIN_USERID);
//		// UserUtils.removeSessionCache(SysConstants.SESSION_KEY_LOGIN_USER);
//		serviceFactory.getDaoFactory().getSessionDao().delete(getSession().getId());// 删除redis session key
//		UserUtils.getSession().invalidate();// 删除cookie session key
//	}

	public static boolean isLogined()
	{
		User user = (User) UserUtils.getSession().getAttribute(SysConstants.SESSION_KEY_LOGIN_USER);
		return user != null ? true : false;
	}

	/*public static User getUser()
	{
		User user=(User) getSessionCache(SysConstants.SESSION_KEY_LOGIN_USER);
		if(user==null){
			Object userId = ServletUtils.getRequest().getSession().getAttribute("userId");
			if(userId!=null)
			{

				user = userService.findOne(userId);
				if(user!=null){
					user.setCompany(
							serviceFactory.getDaoFactory().getCommonDao().getEntity(Company.class, user.getCompanyId()));
				}
				return user;
			}
		}
		return user;
	}*/

//	public static User updateSessionUser()
//	{
//		User user = (User) getSessionCache(SysConstants.SESSION_KEY_LOGIN_USER);
//		if (user != null)
//		{
//			user = serviceFactory.getDaoFactory().getUserDao().get(user.getId());
//			user.setCompany(
//					serviceFactory.getDaoFactory().getCommonDao().getEntity(Company.class, user.getCompanyId()));
//			removeSessionCache(SysConstants.SESSION_KEY_LOGIN_USER);
//			putSessionCache(SysConstants.SESSION_KEY_LOGIN_USER, user);
//		}
//
//		return user;
//	}


	
//	public static Long[] getBusinessDataAuthorizationUser()
//	{
//		Long[] userIds = serviceFactory.getUserService().findSharedEmployeeIds(UserUtils.getUserId());
//		return userIds;
//	}

	public static HttpSession getSession()
	{
		HttpServletRequest request = ServletUtils.getRequest();
		return request != null ? request.getSession() : null;
	}


	public static String entryptPassword(String plainPassword)
	{
		String plain = Encodes.unescapeHtml(plainPassword);
		byte[] salt = Digests.generateSalt(SysConstants.SALT_SIZE);
		byte[] hashPassword = Digests.sha1(plain.getBytes(), salt, SysConstants.HASH_INTERATIONS);
		return Encodes.encodeHex(salt) + Encodes.encodeHex(hashPassword);
	}

	/**
	 * 验证原始密码
	 * @param plainPassword 明文密码
	 * @param password 密文密码
	 * @return 验证成功返回true
	 */
	public static boolean validatePassword(String plainPassword, String password)
	{
		String plain = Encodes.unescapeHtml(plainPassword);
		byte[] salt = Encodes.decodeHex(password.substring(0, 16));
		byte[] hashPassword = Digests.sha1(plain.getBytes(), salt, SysConstants.HASH_INTERATIONS);
		return password.equals(Encodes.encodeHex(salt) + Encodes.encodeHex(hashPassword));
	}

	/**
	 * <pre>
	 * 校验邮箱验证码
	 * </pre>
	 * @param validCode
	 * @return
	 */
	public static boolean validateSmsValidCode(String email, String validCode)
	{
		// 校验短信手机
		Object session_sms_mobile = getSessionCache(SysConstants.SESSION_KEY_SMS_EMAIL);
		if (session_sms_mobile == null)
		{
			return false;
		}
		else if (!session_sms_mobile.equals(email))
		{
			return false;
		}
		// 校验短信验证码
		Object session_sms_validCode = getSessionCache(SysConstants.SESSION_KEY_SMS_VALIDATECODE);
		String wanneng = SystemConfigUtil.getWanNengCode();

		boolean isValidate = false;
		if (session_sms_validCode != null)
		{
			if (wanneng == null)
			{
				isValidate = validCode.equals(session_sms_validCode);
			}
			else
			{
				isValidate = validCode.equals(session_sms_validCode) || validCode.equals(wanneng);
			}
		}

		return isValidate;
	}

	/**
	 * <pre>
	 * 清除当前session手机验证码
	 * </pre>
	 */
	public static void clearSmsValidCode()
	{
		removeSessionCache(SysConstants.SESSION_KEY_SMS_EMAIL);
		removeSessionCache(SysConstants.SESSION_KEY_SMS_VALIDATECODE);
	}

	// ============== User Session Cache (session 可以用第三方缓存代替：redis、ehcache等)==============


	public static Object getSessionCache(String key)
	{
		return getSessionCache(key, null);
	}

	public static Object getSessionCache(String key, Object defaultValue)
	{
		Object obj = getSession().getAttribute(key);
		return obj == null ? defaultValue : obj;
	}

	public static void putSessionCache(String key, Object value)
	{
		HttpSession session = getSession();
		if (session != null)
		{
			session.setAttribute(key, value);
			if (session.getAttribute("host") == null)
			{
				session.setAttribute("host", ServletUtils.getRequest().getRemoteHost());
			}
		}
		getSession().setAttribute(key, value);
	}

	public static void removeSessionCache(String key)
	{
		getSession().removeAttribute(key);
	}


}
