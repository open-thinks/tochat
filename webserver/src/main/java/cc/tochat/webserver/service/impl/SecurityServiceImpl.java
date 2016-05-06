/**   
 *  Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 *
* @Title: SecurityServiceImpl.java 
* @Package cc.tochat.webserver.service.impl 
* @Description: TODO
* @author dailey.yet@outlook.com  
* @date May 6, 2016
* @version V1.0   
*/
package cc.tochat.webserver.service.impl;

import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import cc.tochat.webserver.model.IConstant;
import cc.tochat.webserver.service.SecurityService;

/**
 * @author dailey.yet@outlook.com
 *
 */
public class SecurityServiceImpl implements SecurityService {

	/* (non-Javadoc)
	 * @see cc.tochat.webserver.service.SecurityService#validateEndpoit(javax.websocket.Session)
	 */
	@Override
	public boolean validateEndpoit(Session webSocketSession) {
		HttpSession httpSession = (HttpSession) webSocketSession.getUserProperties().get(
				IConstant.ATTRIBUTE_HTTP_SESSION);
		if (httpSession != null && httpSession.getAttribute(IConstant.SESSION_USER) != null) {
			return true;
		}
		return false;
	}

}
