/*
 *  Copyright 2023 Red Hat
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package org.patternfly.showcase.component;

import org.patternfly.showcase.Snippet;
import org.patternfly.showcase.SnippetPage;

import static org.jboss.elemento.Elements.div;
import static org.jboss.elemento.Elements.p;
import static org.patternfly.component.backtotop.BackToTop.backToTop;
import static org.patternfly.showcase.Code.code;

public class BackToTopComponent extends SnippetPage {

    public BackToTopComponent() {
        super("Back to top",
                "https://patternfly-java.github.io/patternfly-java/org/patternfly/component/backtotop/BackToTop.html",
                "https://www.patternfly.org/components/back-to-top/design-guidelines",
                p().textContent(
                        "The back to top component is a shortcut that allows users to quickly navigate to the top of a lengthy content page.")
                        .element());

        addSnippet(new Snippet("btt-basic", "Basic",
                code.get("btt-basic"), () ->
                // @code-start:btt-basic
                div().id("ws-core-c-back-to-top-basic")
                        .add(backToTop().alwaysVisible())
                        .element()
        // @code-end:btt-basic
        ));
    }
}
