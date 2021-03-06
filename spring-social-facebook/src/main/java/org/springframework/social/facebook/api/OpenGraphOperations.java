/*
 * Copyright 2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.social.facebook.api;

import org.springframework.util.MultiValueMap;


/**
 * Defines operations for working with Facebook OpenGraph actions.
 * @author habuma
 */
public interface OpenGraphOperations {
	
	static final ActionMetadata EMPTY_ACTION_METADATA = new ActionMetadata();

	/**
	 * @return Operations for working with built-in general OpenGraph actions such as "og.like" and "og.follow".
	 */
	GeneralActions generalActions();

	/**
	 * @return Operations for working with built-in book-related OpenGraph actions.
	 */
	BookActions bookActions();
	
	/**
	 * @return Operations for working with built-in music-related OpenGraph actions.
	 */
	MusicActions musicActions();
	
	/**
	 * @return Operations for working with built-in video-related OpenGraph actions.
	 */
	VideoActions videoActions();
	
	/**
	 * @return Operations for working with built-in fitness-related OpenGraph actions.
	 */
	FitnessActions fitnessActions();
	
	/**
	 * Deletes an action.
	 * @param actionId The action ID.
	 */
	void deleteAction(String actionId);

	/**
	 * Posts a custom (application-defined) action for an object specified by the given object URL.
	 * @param action The application specific action to post, without the application's namespace. (eg, "drink")
	 * @param objectType The application specific object type, without the application's namespace. (eg, "beverage")
	 * @param objectUrl The URL of the object that is the target of the action.
	 * @return the ID of the posted action.
	 */
	String publishAction(String action, String objectType, String objectUrl);
	
	String publishAction(String action, MultiValueMap<String, Object> parameters, boolean builtInAction);
	
	/**
	 * The way a application sends notification to users
	 * 
	 * @param userId the facebook user id
	 * @param href The relative path/GET params of the  canvas APP
	 * @param template The customized text of the notification. See 
	 * https://developers.facebook.com/docs/games/notifications/#templating for
	 * customized messages
	 * 
	 * @return true if the user received the notification false otherwise
	 * 
	 * @see https://developers.facebook.com/docs/games/notifications/
	 */
	void sendAppNotification(String userId, String href, String template);
}
