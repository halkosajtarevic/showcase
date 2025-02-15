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
import static org.patternfly.component.button.Button.button;
import static org.patternfly.component.emptystate.EmptyState.emptyState;
import static org.patternfly.component.emptystate.EmptyStateActions.emptyStateActions;
import static org.patternfly.component.emptystate.EmptyStateBody.emptyStateBody;
import static org.patternfly.component.emptystate.EmptyStateFooter.emptyStateFooter;
import static org.patternfly.component.emptystate.EmptyStateHeader.emptyStateHeader;
import static org.patternfly.showcase.Code.code;
import static org.patternfly.style.PredefinedIcon.check;
import static org.patternfly.style.PredefinedIcon.cubes;
import static org.patternfly.style.PredefinedIcon.search;
import static org.patternfly.style.Size.lg;
import static org.patternfly.style.Size.sm;
import static org.patternfly.style.Size.xl;
import static org.patternfly.style.Size.xs;
import static org.patternfly.style.Variable.globalVar;

public class EmptyStateComponent extends SnippetPage {

    public EmptyStateComponent() {
        super("Empty state",
                "https://patternfly-java.github.io/patternfly-java/org/patternfly/component/emptystate/EmptyState.html",
                "https://www.patternfly.org/components/empty-state/design-guidelines",
                p().textContent(
                        "An empty state is a screen that is not yet populated with data or information. Empty states typically contain a short message and next steps for the user.")
                        .element());

        addSnippet(new Snippet("empty-state-basic", "Basic",
                code.get("empty-state-basic"), () ->
                // @code-start:empty-state-basic
                div()
                        .add(emptyState()
                                .addHeader(emptyStateHeader(4)
                                        .icon(cubes)
                                        .text("Empty state"))
                                .addBody(emptyStateBody()
                                        .textContent(
                                                "This represents an the empty state pattern in PatternFly. Hopefully it's simple enough to use but flexible enough to meet a variety of needs."))
                                .addFooter(emptyStateFooter()
                                        .addActions(emptyStateActions()
                                                .add(button("Primary action").primary()))
                                        .addActions(emptyStateActions()
                                                .add(button("Multiple").link())
                                                .add(button("Action Buttons").link())
                                                .add(button("Can").link())
                                                .add(button("Go here").link())
                                                .add(button("In the secondary").link())
                                                .add(button("Action area").link()))))
                        .element()
        // @code-end:empty-state-basic
        ));

        addSnippet(new Snippet("empty-state-xs", "Extra small",
                code.get("empty-state-xs"), () ->
                // @code-start:empty-state-xs
                div()
                        .add(emptyState()
                                .size(xs)
                                .addHeader(emptyStateHeader(4)
                                        .text("Empty state"))
                                .addBody(emptyStateBody()
                                        .textContent(
                                                "This represents an the empty state pattern in PatternFly. Hopefully it's simple enough to use but flexible enough to meet a variety of needs."))
                                .addFooter(emptyStateFooter()
                                        .addActions(emptyStateActions()
                                                .add(button("Multiple").link())
                                                .add(button("Action Buttons").link())
                                                .add(button("Can").link())
                                                .add(button("Go here").link())
                                                .add(button("In the secondary").link())
                                                .add(button("Action area").link()))))
                        .element()
        // @code-end:empty-state-xs
        ));

        addSnippet(new Snippet("empty-state-small", "Small",
                code.get("empty-state-small"), () ->
                // @code-start:empty-state-small
                div()
                        .add(emptyState()
                                .size(sm)
                                .addHeader(emptyStateHeader(4)
                                        .icon(cubes)
                                        .text("Empty state"))
                                .addBody(emptyStateBody()
                                        .textContent(
                                                "This represents an the empty state pattern in PatternFly. Hopefully it's simple enough to use but flexible enough to meet a variety of needs."))
                                .addFooter(emptyStateFooter()
                                        .addActions(emptyStateActions()
                                                .add(button("Primary action").primary()))
                                        .addActions(emptyStateActions()
                                                .add(button("Multiple").link())
                                                .add(button("Action Buttons").link())
                                                .add(button("Can").link())
                                                .add(button("Go here").link())
                                                .add(button("In the secondary").link())
                                                .add(button("Action area").link()))))
                        .element()
        // @code-end:empty-state-small
        ));

        addSnippet(new Snippet("empty-state-large", "Large",
                code.get("empty-state-large"), () ->
                // @code-start:empty-state-large
                div()
                        .add(emptyState()
                                .size(lg)
                                .addHeader(emptyStateHeader(4)
                                        .icon(cubes)
                                        .text("Empty state"))
                                .addBody(emptyStateBody()
                                        .textContent(
                                                "This represents an the empty state pattern in PatternFly. Hopefully it's simple enough to use but flexible enough to meet a variety of needs."))
                                .addFooter(emptyStateFooter()
                                        .addActions(emptyStateActions()
                                                .add(button("Primary action").primary()))
                                        .addActions(emptyStateActions()
                                                .add(button("Multiple").link())
                                                .add(button("Action Buttons").link())
                                                .add(button("Can").link())
                                                .add(button("Go here").link())
                                                .add(button("In the secondary").link())
                                                .add(button("Action area").link()))))
                        .element()
        // @code-end:empty-state-large
        ));

        addSnippet(new Snippet("empty-state-xl", "Extra large",
                code.get("empty-state-xl"), () ->
                // @code-start:empty-state-xl
                div()
                        .add(emptyState()
                                .size(xl)
                                .addHeader(emptyStateHeader(4)
                                        .icon(cubes)
                                        .text("Empty state"))
                                .addBody(emptyStateBody()
                                        .textContent(
                                                "This represents an the empty state pattern in PatternFly. Hopefully it's simple enough to use but flexible enough to meet a variety of needs."))
                                .addFooter(emptyStateFooter()
                                        .addActions(emptyStateActions()
                                                .add(button("Primary action").primary()))
                                        .addActions(emptyStateActions()
                                                .add(button("Multiple").link())
                                                .add(button("Action Buttons").link())
                                                .add(button("Can").link())
                                                .add(button("Go here").link())
                                                .add(button("In the secondary").link())
                                                .add(button("Action area").link()))))
                        .element()
        // @code-end:empty-state-xl
        ));

        addSnippet(new Snippet("empty-state-spinner", "Spinner",
                code.get("empty-state-spinner"), () ->
                // @code-start:empty-state-spinner
                div()
                        .add(emptyState()
                                .addHeader(emptyStateHeader(4)
                                        .spinner("Loading...")
                                        .text("Loading")))
                        .element()
        // @code-end:empty-state-spinner
        ));

        addSnippet(new Snippet("empty-state-no-match", "No match found",
                code.get("empty-state-no-match"), () ->
                // @code-start:empty-state-no-match
                div()
                        .add(emptyState()
                                .addHeader(emptyStateHeader(4)
                                        .icon(search)
                                        .text("No results found"))
                                .addBody(emptyStateBody()
                                        .textContent("No results match the filter criteria. Clear all filters and try again."))
                                .addFooter(emptyStateFooter()
                                        .addActions(emptyStateActions()
                                                .add(button("Clear all filters").link()))))
                        .element()
        // @code-end:empty-state-no-match
        ));

        addSnippet(new Snippet("empty-state-color", "Custom icon color",
                code.get("empty-state-color"), () ->
                // @code-start:empty-state-color
                div()
                        .add(emptyState()
                                .addHeader(emptyStateHeader(4)
                                        .icon(check, globalVar("success-color", "100"))
                                        .text("Custom icon color"))
                                .addBody(emptyStateBody()
                                        .textContent(
                                                "This represents an the empty state pattern in PatternFly. Hopefully it's simple enough to use but flexible enough to meet a variety of needs.")))
                        .element()
        // @code-end:empty-state-color
        ));
    }
}
