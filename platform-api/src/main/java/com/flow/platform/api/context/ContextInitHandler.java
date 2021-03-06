/*
 * Copyright 2017 flow.ci
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.flow.platform.api.context;

import com.flow.platform.api.util.CommonUtil;
import com.flow.platform.core.context.AbstractContextInitHandler;
import com.flow.platform.core.context.SpringContext;
import com.flow.platform.util.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * @author yh@firim
 */
@Component
public class ContextInitHandler extends AbstractContextInitHandler {

    private static final Logger LOGGER = new Logger(ContextInitHandler.class);

    @Autowired
    private SpringContext springContext;

    @Override
    public SpringContext getSpringContext() {
        return springContext;
    }

    @Value("${jfiglet.message}")
    private String tipMessage;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        super.onApplicationEvent(event);

        // show start success message
        LOGGER.trace(CommonUtil.showJfigletMessage(tipMessage));
    }
}
