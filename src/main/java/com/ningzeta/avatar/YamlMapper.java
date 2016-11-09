/*
 * Copyright 2002-2016 the original author or authors.
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
package com.ningzeta.avatar;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.util.HashMap;
import java.util.regex.Pattern;

/**
 * Convert the Yaml to any Object type.
 *
 * @author Ningthoujam Lokhendro
 * @since 11/8/2016
 */
public class YamlMapper {

	private static ObjectMapper objectMapper = new ObjectMapper();
	private String fileName;

	public YamlMapper() {
	}

	public YamlMapper(String fileName) {
		this.fileName = fileName;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public HashMap<String, Object> convert() {
		Yaml yaml = new Yaml();
		HashMap<String, Object> map = (HashMap<String, Object>) yaml.load(getStream());
		return map;
	}

	public <T> T convert(Class<T> toValueType) {
		HashMap<String, Object> map = convert();
		return objectMapper.convertValue(map, toValueType);
	}

	public <T> T convert(String prefix, Class<T> toValueType) {
		HashMap<String, Object> map = convert();
		HashMap<String, Object> preObj = map;

		for (String p : prefix.split(Pattern.quote("."))) {
			preObj = (HashMap<String, Object>) preObj.get(p);
		}

		return objectMapper.convertValue(preObj, toValueType);
	}

	private InputStream getStream() {
		InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(this.fileName);
		return inputStream;
	}
}
