/*
 * Copyright 2003-2010 the original author or authors.
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
package groovy.bugs

import gls.CompilableTestSupport

class Groovy4190Bug extends CompilableTestSupport {
    void testGenericsUsageInMethodCall() {
        shouldCompile """
			class Test4190<E> {
				E someVariable;
				
				protected Test4190() { }
				
				public static <E> Test4190<E> create() {
					return new Test4190<E>();
				}
				
				public static void main(String[] args) {
					Test4190<Integer> t = Test4190.<Integer>create();
				}
			}
        """
    }
    
    void testGenericsUsageInMethodCall2() {
        shouldCompile """
			class Test4190V2<E> {
				public static void main(String[] args) {
					Test4190V2<Integer, String> t = Test4190V2.<Integer, String>create();
				}
			}
        """
    }
}