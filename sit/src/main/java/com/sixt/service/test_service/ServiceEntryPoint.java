/**
 * Copyright 2016-2017 Sixt GmbH & Co. Autovermietung KG
 * Licensed under the Apache License, Version 2.0 (the "License"); you may 
 * not use this file except in compliance with the License. You may obtain a 
 * copy of the License at http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software 
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT 
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the 
 * License for the specific language governing permissions and limitations 
 * under the License.
 */

package com.sixt.service.test_service;

import com.sixt.service.framework.AbstractService;
import com.sixt.service.framework.annotation.OrangeMicroservice;
import com.sixt.service.test_service.handler.RandomHandler;
import com.sixt.service.test_service.handler.RandomHandlerPostHook;
import com.sixt.service.test_service.handler.RandomHandlerPreHook;
import com.sixt.service.test_service.handler.SlowRespondingHandler;

import java.io.PrintStream;

@OrangeMicroservice
public class ServiceEntryPoint extends AbstractService {

    @Override
    public void registerMethodHandlers() {
        registerMethodHandlerFor("TestService.GetRandomString", RandomHandler.class);
        registerPreMethodHandlerHookFor("TestService.GetRandomString", RandomHandlerPreHook.class);
        registerPostMethodHandlerHookFor("TestService.GetRandomString", RandomHandlerPostHook.class);
        registerMethodHandlerFor("TestService.SlowResponder", SlowRespondingHandler.class);
    }

    @Override
    public void displayHelp(PrintStream out) {
        //TODO: display required and optional configuration information
    }

}