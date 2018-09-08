# Browsen
A lightweight Android library for customizable web views 

![](https://github.com/mharis99/Browsen/blob/master/art/browsen1.png)
![](https://github.com/mharis99/Browsen/blob/master/art/browsen2.png)
![](https://github.com/mharis99/Browsen/blob/master/art/browsen3.png)
## Download
Grab via Gradle:
```java
compile 'com.haris.browsen:browsen:1.0'
```
Or Maven:
```java
<dependency>
  <groupId>com.haris.browsen</groupId>
  <artifactId>browsen</artifactId>
  <version>1.0</version>
  <type>pom</type>
</dependency>
``` 
## Usage
#### Default:
```java
Browsen.with(this)
    .setUrl("https://www.google.com")
    .show();

```
#### Custom:
```java
Browsen.with(this)
    .setUrl("https://www.google.com")
    .setTitle("Google in Browsen")
    .setTextColor(R.color.def_text_color)
    .setTopBarColor(R.color.colorPrimary)
    .showTopBar(true)
    .show();
```
#### Without TopBar:
```java
Browsen.with(this)
    .setUrl("https://www.google.com")
    .setTitle("Google in Browsen")
    .showTopBar(false)
    .show();
```

## Authors

* **Muhammad Haris** - (https://d1nnqglf0gap4i.cloudfront.net/index.html , https://github.com/mharis99)

## Licence
```
Copyright 2018 Glass, Inc.


Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
