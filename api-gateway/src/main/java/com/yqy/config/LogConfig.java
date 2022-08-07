package com.yqy.config;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yqy
 * @date 2022-08-06-11:24
 */
@Data
@NoArgsConstructor
public class LogConfig {
    private boolean consoleLog;
    private boolean cacheLog;
}
