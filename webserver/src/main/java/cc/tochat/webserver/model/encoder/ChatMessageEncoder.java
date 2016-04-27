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
* @Title: ChatMessageEncoder.java 
* @Package cc.tochat.webserver.model.encoder 
* @Description: TODO
* @author dailey.yet@outlook.com  
* @date Apr 27, 2016
* @version V1.0   
*/
package cc.tochat.webserver.model.encoder;

import javax.json.Json;
import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

import cc.tochat.webserver.model.ChatMessage;
import cc.tochat.webserver.model.IConstant;

/**
 * @author dailey.yet@outlook.com
 *
 */
public class ChatMessageEncoder implements Encoder.Text<ChatMessage> {

	@Override
	public void destroy() {

	}

	@Override
	public void init(EndpointConfig cfg) {

	}

	@Override
	public String encode(ChatMessage chatMsgObj) throws EncodeException {
		return Json.createObjectBuilder().add(IConstant.MSG_ID, chatMsgObj.getId())
				.add(IConstant.MESSAGE_TYPE, chatMsgObj.getType()).add(IConstant.MSG_ROOM, chatMsgObj.getId())
				.add(IConstant.MSG_FROM, chatMsgObj.getFrom()).add(IConstant.MSG_TO, chatMsgObj.getTo())
				.add(IConstant.MSG_CONTENT, chatMsgObj.encode())
				.add(IConstant.MSG_TIMESTAMP, chatMsgObj.getTimestamp()).build().toString();
	}

}