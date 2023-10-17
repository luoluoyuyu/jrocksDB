/**
 * Licensed to the OpenIO.Net under one or more
 * contributor license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.openio.opendb.tool;

import java.io.File;

public class FileUtils {

  public static void createDirectoryIfNotExists(String directoryPath) {
    File directory = new File(directoryPath);
    if (!directory.exists()) {
      boolean success = directory.mkdirs();
      if (success) {
        System.out.println("目录已创建：" + directoryPath);
      } else {
        System.err.println("无法创建目录：" + directoryPath);
      }
    }
  }


  public static void createFileIfNotExists(String filePath) {
    File file = new File(filePath);
    if (!file.exists()) {
      File parentDirectory = file.getParentFile();
      if (parentDirectory != null) {
        createDirectoryIfNotExists(parentDirectory.getPath());
      }

      try {
        boolean success = file.createNewFile();
        if (success) {
          System.out.println("文件已创建：" + filePath);
        } else {
          System.err.println("无法创建文件：" + filePath);
        }
      } catch (Exception e) {
        System.err.println("创建文件时出现异常：" + e.getMessage());
      }
    }
  }
}
