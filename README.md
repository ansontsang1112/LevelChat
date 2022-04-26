**Must update version will be shown in https://plugin.hypernite.com/**

A plugin for showing the level changes by chat bar and titles.

#### Installation
1. Download and put the plugin into /plugins/
2. Restart or load the plugin into the server
3. Edit the configuration in the plugin
4. Happy to use

#### Requirement
**Java 17** or above.<br>
Minecraft Server with **1.18 or above**.

#### Commands
| Command | Description | Permission |
| ------ | ------ | ------ |
| lc-reload | Reload the plugin | levelchat.reload (Default OP) |


#### Dependancy
| Soft Dependancy | Dependancy |
| ------ | ----- | 
| PlaceholderAPI | Nil

#### Features
|  | Sample |
| ------ | ----- | 
| Console update Log | ``` ansontsang1112 has reached 10 at 2022/03/25 12:46:32 ```
| User upgrade message | ``` Congratulation! Your level changed from LV4 to LV5 ```
| User downgrade message | ``` Oh no, your level reduced from 10 to 5 ```
| Global Message | ``` Congratulation, ansontsang1112 has reached level 99 ```



#### config.yml
```yml
# Level Chat Configuration
# Please do not change any placeholder (%xxx%)
# All duration calculated in second

settings:
  enable: true
  enable_console_log: false
  console_message: "%player% has reached %level% at %time%"
  prefix: "[&aLevelChat&f]"
  
chat_format:
  enable: true
  format: "[LV.%level%]&f"

titles:
  enable: false
  title: "&aLevel Up"
  subtitle: "Congratulation, you are now at level %level%"
  duration: 10

message:
  chat:
    enable: true
    upgrade_msg: "Congratulation, level Up! Your level changed from LV.%oldLevel% to LV.%level%"
    downgrade_msg: "Oh no, your level reduced from %oldLevel% to %level%"
  global:
    enable: false
    global_announcement_requirement: # When the user reach this level, a global announcement will be made.
      - 10
      - 20
      - 30
    msg: "Congratulation, %player% has reached level %level%"
```
