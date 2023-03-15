/*
 * Copyright 2023 the original author or authors.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * https://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.openrewrite.xml;

import org.openrewrite.xml.tree.Xml;

public class ChangeTagNameVisitor<P> extends XmlVisitor<P> {

    private final Xml.Tag scope;
    private final String newName;

    public ChangeTagNameVisitor(Xml.Tag scope, String newName) {
        this.scope = scope;
        this.newName = newName;
    }

    @Override
    public Xml visitTag(Xml.Tag tag, P p) {
        Xml.Tag t = (Xml.Tag) super.visitTag(tag, p);
        if (scope.isScope(t)) {
            t = t.withName(newName);
        }

        return t;
    }
}
