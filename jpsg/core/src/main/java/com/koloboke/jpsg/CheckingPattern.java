/*
 * Copyright 2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.koloboke.jpsg;

import java.util.regex.Pattern;


public final class CheckingPattern {

    public static CheckingPattern compile(String checkingRegex, String targetRegex) {
        return new CheckingPattern(checkingRegex, targetRegex, RegexpUtils.STANDARD_TEMPLATE_FLAGS);
    }

    public static CheckingPattern compile(String checkingRegex, String targetRegex, int flags) {
        return new CheckingPattern(checkingRegex, targetRegex, flags);
    }

    private final Pattern checkingPattern, targetPattern;

    private CheckingPattern(String checkingRegex, String targetRegex, int flags) {
        checkingPattern = Pattern.compile(checkingRegex, flags);
        targetPattern = Pattern.compile(targetRegex, flags);
    }

    public CheckingMatcher matcher(CharSequence input) {
        return CheckingMatcher.Companion.create(input, checkingPattern, targetPattern);
    }
}
