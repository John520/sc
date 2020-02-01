package com.john.sc.consumer.fallback;

import com.netflix.hystrix.HystrixInvokableInfo;
import com.netflix.ribbon.hystrix.FallbackHandler;
import rx.Observable;

import java.util.Map;

//public class AddServiceFallback implements FallbackHandler<String> {
//    @Override
//    public Observable<String> getFallback(HystrixInvokableInfo<?> hystrixInfo, Map<String, Object> requestProperties) {
//
//        return "fallack";
//    }
//}
