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

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.Test;

/**
 * Test for the YamlMapper.
 *
 * @author Ningthoujam Lokhendro
 * @since 11/8/2016
 */
public class YamlMapperTest {

	@Test
	public void ConvertTest() throws JsonProcessingException {

		YamlMapper yamlMapper = new YamlMapper("app.yml");
		DBConnectionParam oracleParam = yamlMapper.convert("myapp.db.oracle", DBConnectionParam.class);
		DBConnectionParam mariaParam = yamlMapper.convert("myapp.db.mariadb", DBConnectionParam.class);
		assert oracleParam.getHostname().equals("db.ningzeta.com");
		assert mariaParam.getHostname().equals("db.ningzeta.com");
	}
}
