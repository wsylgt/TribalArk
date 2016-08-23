package com.cn.utils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeanUtils;
import sun.misc.BASE64Decoder;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 实体Bean工具类
 * <p>Entity和Model之间属性的赋值<br>
 * Entity和Model两个实体Bean属性结构可以不一样，但必须保证属性名称和类型一样，<br>
 * 没有的属性，和类型不一样的，均为null
 * 使用介绍：*To*(对象，目标对象.class)
 * @author 刘广飞
 * @version 1.0 2016/4/25
 */
@SuppressWarnings({ "unchecked", "restriction" })
public class ConvertUtils {
    
    /** 日志对象 */
    private static Log logger = LogFactory.getLog(ConvertUtils.class);

    /**
     * 将Entity属性的值赋值到Model中
     * @param entity:entity包下实体Bean  modelClass:model包下实体Bean对象.class
     * @return model包下实体Bean
     * BeanUtils所花费的时间要超过取数 据、将其复制到对应的 value对象（通过手动调用get和set方法），以及通过串行化将其返回到远程的客户机的时间总和
     */
    public static <T> T entityToModel(Object entity, Class<T> modelClass) {
        logger.debug("entityToModel : Entity属性的值赋值到Model");
        Object model = null;
        try {
            model = modelClass.newInstance();
        } catch (InstantiationException e) {
            logger.error("entityToModel : 实例化异常", e);
        } catch (IllegalAccessException e) {
            logger.error("entityToModel : 安全权限异常", e);
        }
        BeanUtils.copyProperties(entity, model);
        return (T)model;
    }

    /**
     * 将Model属性的值赋值到Entity中
     * @param  model:model包下实体Bean entityClass:entity包下实体Bean对象.class
     * @return entity包下实体Bean
     */
    public static <T> T modelToEntity(Object model, Class<T> entityClass) {
        logger.debug("modelToEntity : Model属性的值赋值到Entity");
        Object entity = null;
        try {
            entity = entityClass.newInstance();
        } catch (InstantiationException e) {
            logger.error("modelToEntity : 实例化异常", e);
        } catch (IllegalAccessException e) {
            logger.error("modelToEntity : 安全权限异常", e);
        }

        BeanUtils.copyProperties(model, entity);
        return (T)entity;
    }

    /**
     * 将null变换成空值
     * @param  value 要变换的值
     * @return 变换后值
     */
    public static String nullToEmpty(String value) {
        logger.debug("nullToEmpty : 将null变换成空值");
        if (value == null) {
            return "";
        } else {
            return value.trim();
        }
    }

    /**
     * 将base64位图片字符串转换成InputStream类型
     * @param imgBase64
     * @return imgInputStream 图片流
     */
    public static InputStream byteToInputStream(String imgBase64) throws IOException {

        BASE64Decoder decoder = new BASE64Decoder();
        ByteArrayInputStream byteArrInputStream = null;

        if (imgBase64 != null && imgBase64.length() > 0) {
            // Base64解码
            byte[] bytes = decoder.decodeBuffer(imgBase64);
            for (int i = 0; i < bytes.length; i++) {
                if (bytes[i] < 0) {
                    bytes[i] += 256;
                }
            }

            // 图片流
            byteArrInputStream = new ByteArrayInputStream(bytes);
        }
        return byteArrInputStream;
    }
    
    /**
     * 列表对象转换成Map对象 
     * @param list 变换对象列表
     * @param keyFieldName 主键项目名称
     * @return 变换结果Map
     */
    public static <K,T> Map<K,T> listToHashMap(List<T> list, String keyFieldName)
    {
        Map<K ,T> map = new HashMap<K ,T>();
        
        for(T t : list)
        {
            Class<?> cls = t.getClass();
            try{
                Field field = cls.getDeclaredField(keyFieldName);
                field.setAccessible(true);
                K fieldValue=(K)field.get(t);
                map.put(fieldValue, t);
            
            }catch(Exception e)
            {
                logger.error("makeHashMap：属性取得失败-----结束-----" + e);
            }
        }
        return map;
    }
    /**
     * 取得两个列表相同的内容
     * @param src 原列表
     * @param desc 目标列表
     * @return 相同列表
     */
    public static <T> List<T> getSameList(List<T> src, List<T> desc)
    {
        List<T> list = new ArrayList<T>();

        for(T t : src)
        {
            if(desc.contains(t))
            {
                list.add(t);
            }
        }
        return list;
    }
    /**
     * 取得两个列表不同的内容
     * @param src 原列表
     * @param desc 目标列表
     * @return 差分列表
     */
    public static <T> List<T> getDiffList(List<T> src, List<T> desc)
    {
        List<T> list = new ArrayList<T>();

        for(T t : src)
        {
            if(!desc.contains(t))
            {
                list.add(t);
            }
        }
        return list;
    }
    
    /**
     * 根据键值列表取得值列表
     * @param keys 键值列表
     * @param map 目标Map
     * @return 值列表
     */
    public static <K, T> List<T> getValueList(List<K> keys, Map<K,T> map)
    {
        List<T> list = new ArrayList<T>();

        for(K k : keys)
        {
            if(map.get(k) != null)
            {
                list.add(map.get(k));
            }
        }
        return list;
    }
}
