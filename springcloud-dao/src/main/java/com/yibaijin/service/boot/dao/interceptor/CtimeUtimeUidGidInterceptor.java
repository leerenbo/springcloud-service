//package com.yibaijin.service.boot.dao.interceptor;
//
//import com.yibaijin.service.boot.dao.model.auth.UserFunctionRoleGroupDetails;
//import org.apache.commons.lang.reflect.FieldUtils;
//import org.apache.ibatis.executor.Executor;
//import org.apache.ibatis.mapping.MappedStatement;
//import org.apache.ibatis.plugin.*;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//
//import java.lang.reflect.Field;
//import java.util.Properties;
//import java.util.stream.Collectors;
//
//@Intercepts({@Signature(
//        type = Executor.class,
//        method = "update",
//        args = {MappedStatement.class, Object.class})})
//public class CtimeUtimeUidGidInterceptor implements Interceptor {
//
//
//    @Override
//    public Object intercept(Invocation invocation) throws Throwable {
//        if (invocation.getArgs()[1] != null) {
//            Object model = invocation.getArgs()[1];
//            Class modelClass = model.getClass();
//            Long currentTimeMillis = System.currentTimeMillis();
//
//            Field ctimefield = FieldUtils.getField(modelClass, "ctime", true);
//            if (ctimefield != null) {
//                Long ctime = (Long) FieldUtils.readField(ctimefield, model, true);
//                if (ctime == null) {
//                    FieldUtils.writeField(ctimefield, model, currentTimeMillis, true);
//                }
//            }
//
//            Field utimefield = FieldUtils.getField(modelClass, "utime", true);
//            if (utimefield != null) {
//                FieldUtils.writeField(utimefield, model, currentTimeMillis, true);
//            }
//
//
//            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//            if (authentication != null && authentication.getDetails() instanceof UserFunctionRoleGroupDetails) {
//                UserFunctionRoleGroupDetails userDetails = (UserFunctionRoleGroupDetails) authentication.getDetails();
//
//                Field uidField = FieldUtils.getField(modelClass, "uid", true);
//                if (uidField != null && FieldUtils.readField(uidField, model, true) == null) {
//                    FieldUtils.writeField(uidField, model, userDetails.getUid(),true);
//                }
//
//                Field gidField = FieldUtils.getField(modelClass, "gid", true);
//                if (gidField != null && FieldUtils.readField(gidField, model, true) == null && userDetails.getGroupAuthority() != null) {
//                    FieldUtils.writeField(gidField, model, userDetails.getGroupAuthority().getId(),true);
//                }
//            }
//        }
//        return invocation.proceed();
//    }
//
//    @Override
//    public Object plugin(Object target) {
//        return Plugin.wrap(target, this);
//    }
//
//    @Override
//    public void setProperties(Properties properties) {
//        System.out.println(properties.keySet().stream().map(Object::toString).collect(Collectors.joining()));
//
//    }
//}
