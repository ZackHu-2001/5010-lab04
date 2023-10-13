#!/bin/bash

# 指定要打包的第一个文件夹的路径
source_path1="src"

# 指定要打包的第二个文件夹的路径
source_path2="test"

# 指定 Zip 文件的名称和路径
zip_filename="Archive.zip"

# 使用 'find' 命令列出每个文件夹下除以"."开头的文件
find "$source_path1" -type f -not -name ".*" > files_to_zip1.txt
find "$source_path2" -type f -not -name ".*" > files_to_zip2.txt

# 使用 'cat' 命令将两个文件列表合并
cat files_to_zip1.txt files_to_zip2.txt > combined_files_to_zip.txt

# 使用 'zip' 命令将合并后的文件列表打包成 Zip 文件
zip -@ "$zip_filename" < combined_files_to_zip.txt

# 删除临时文件
rm -f files_to_zip1.txt files_to_zip2.txt combined_files_to_zip.txt

# 检查是否成功创建 Zip 文件
if [ $? -eq 0 ]; then
  echo "成功创建 Zip 文件: $zip_filename，包含两个文件夹的内容，剔除以\".\"开头的配置文件"
else
  echo "创建 Zip 文件时发生错误"
fi