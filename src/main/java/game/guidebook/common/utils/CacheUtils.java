package game.guidebook.common.utils;

import game.common.cis.ComponentContextLoader;
import game.guidebook.common.SystemConfigUtil;
import game.guidebook.constants.SysConstants;
import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

import java.util.HashMap;
import java.util.Map;

/**
 * Cache工具类
 * @author zhaojt
 * @version 2013-5-29
 */
public class CacheUtils {
	
	private static CacheManager cacheManager = ((CacheManager) ComponentContextLoader.getBean("ehCacheManagerFactory"));

	public static String cacheType = SystemConfigUtil.getConfig(SysConstants.CACHE_TYPE);
	private static final String PUBLIC_CACHE_SYS = "PUBLIC_CACHE_SYS";
	private static final Integer cacheMinute=Integer.parseInt(SystemConfigUtil.getConfig(SysConstants.CACHE_MINUTE));

	/**
	 * 获取SYS_CACHE缓存
	 * @param key
	 * @return
	 */
	public static Object get(String key) {
		return get(PUBLIC_CACHE_SYS, key);
	}
	
	/**
	 * 写入SYS_CACHE缓存
	 * @param key
	 * @return
	 */
	public static void put(String key, Object value) {
		put(PUBLIC_CACHE_SYS, key, value);
	}
	
	/**
	 * 从SYS_CACHE缓存中移除
	 * @param key
	 * @return
	 */
	public static void remove(String key) {
		remove(PUBLIC_CACHE_SYS, key);
	}
	
	/**
	 * 获取缓存
	 * @param cacheName
	 * @param key
	 * @return
	 */
	public static Object get(String cacheName, String key) {
		
		if (cacheType.equals(SysConstants.CACHE_TYPE_EHCACHE))
		{// chcache框架
			Element element = getCache(cacheName).get(key);
			return element==null?null:element.getObjectValue();
		}
		else if (cacheType.equals(SysConstants.CACHE_TYPE_REDIS))
		{// redis框架
			if (JedisUtils.mapObjectExists(cacheName, key))
			{
				return JedisUtils.getObjectMap(cacheName).get(key);
			}
		}
		return null;	
	}

	/**
	 * 写入缓存
	 * @param cacheName
	 * @param key
	 * @param value
	 */
	public static void put(String cacheName, String key, Object value) {
		if (cacheType.equals(SysConstants.CACHE_TYPE_EHCACHE))
		{// chcache框架
			Element element = new Element(key, value);
			getCache(cacheName).put(element);
			getCache(cacheName).flush();
		}
		else if (cacheType.equals(SysConstants.CACHE_TYPE_REDIS))
		{// redis框架：目前效率低下
			Map<String, Object> map = new HashMap<String, Object>();
			map.put(key, value);
			if (!JedisUtils.exists(cacheName))
			{
				JedisUtils.setObjectMap(cacheName, map, cacheMinute*60);
			}
			else
			{
				JedisUtils.mapObjectPut(cacheName, map);
			}
		}
	}

	/**
	 * 从缓存中移除
	 * @param cacheName
	 * @param key
	 */
	public static void remove(String cacheName, String key) {
		if (cacheType.equals(SysConstants.CACHE_TYPE_EHCACHE))
		{// chcache框架
			getCache(cacheName).remove(key);
			getCache(cacheName).flush();
		}
		else if (cacheType.equals(SysConstants.CACHE_TYPE_REDIS))
		{
			JedisUtils.mapObjectRemove(cacheName, key);
		}
	}
	/**
	 * 从缓存中移除缓存域
	 * @param cacheName
	 */
	public static void removeCacheName(String cacheName) {
		if (cacheType.equals(SysConstants.CACHE_TYPE_EHCACHE))
		{// chcache框架
			removeCache(cacheName);
		}
		else if (cacheType.equals(SysConstants.CACHE_TYPE_REDIS))
		{
			JedisUtils.delObject(cacheName);
		}
		
		
	}
	/**
	 * 获得一个Cache，没有则创建一个。
	 * @param cacheName
	 * @return
	 */
	public static Cache getCache(String cacheName){
		Cache cache = cacheManager.getCache(cacheName);
		if (cache == null){
			cacheManager.removeCache(cacheName);
			cacheManager.addCache(cacheName);
			cache = cacheManager.getCache(cacheName);
			cache.getCacheConfiguration().setEternal(true);
		}
		return cache;
	}
	/**
	 * 删除一个Cache域。
	 * @param cacheName
	 * @return
	 */
	private static void removeCache(String cacheName){
		cacheManager.removeCache(cacheName);
	}
}
