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

import org.jboss.elemento.Id;
import org.patternfly.component.form.FormSelect;
import org.patternfly.component.form.FormSelectOption;
import org.patternfly.component.help.HelperText;
import org.patternfly.showcase.Snippet;
import org.patternfly.showcase.SnippetPage;

import static elemental2.dom.DomGlobal.clearTimeout;
import static elemental2.dom.DomGlobal.setTimeout;
import static java.util.Arrays.asList;
import static org.jboss.elemento.Elements.div;
import static org.jboss.elemento.Elements.p;
import static org.patternfly.component.form.Form.form;
import static org.patternfly.component.form.FormGroup.formGroup;
import static org.patternfly.component.form.FormGroupControl.formGroupControl;
import static org.patternfly.component.form.FormGroupLabel.formGroupLabel;
import static org.patternfly.component.form.FormSelect.formSelect;
import static org.patternfly.component.form.FormSelectOption.formSelectOption;
import static org.patternfly.component.form.FormSelectOptionGroup.formSelectOptionGroup;
import static org.patternfly.component.help.HelperText.helperText;
import static org.patternfly.core.ValidationStatus.default_;
import static org.patternfly.core.ValidationStatus.error;
import static org.patternfly.core.ValidationStatus.success;
import static org.patternfly.core.ValidationStatus.warning;
import static org.patternfly.showcase.Code.code;

public class FormSelectComponent extends SnippetPage {

    public FormSelectComponent() {
        super("Form select",
                "https://patternfly-java.github.io/patternfly-java/org/patternfly/component/form/FormSelect.html",
                "https://www.patternfly.org/components/forms/form-select/design-guidelines",
                p().textContent("A form select embeds browser native select lists into a form.")
                        .element());

        addSnippet(new Snippet("form-select-basic", "Basic",
                code.get("form-select-basic"), () -> {
                    // @code-start:form-select-basic
                    String[] values = { "Mr", "Miss", "Mrs", "Ms", "Dr", "Other" };
                    return div()
                            // if not specified, Id.build(<label>) is used as value
                            .add(formSelect("basic-form-select-0", Id.build("Mrs"))
                                    .addOption(formSelectOption("Select one").placeholder())
                                    .addOptions(asList(values), FormSelectOption::formSelectOption))
                            .element();
                    // @code-end:form-select-basic
                }));

        addSnippet(new Snippet("form-select-validated", "Validated",
                code.get("form-select-validated"), () -> {
                    // @code-start:form-select-validated
                    final double[] handle = { 0 };
                    HelperText helperText = helperText("");
                    FormSelect formSelect = formSelect("validated-form-select-0")
                            .onChange((e, fs, value) -> {
                                clearTimeout(handle[0]);
                                fs.validated(default_);
                                helperText.firstItem()
                                        .status(default_)
                                        .text("Validating...");
                                int number = Integer.parseInt(value);
                                handle[0] = setTimeout(__ -> {
                                    if (number == 0) {
                                        fs.validated(warning);
                                        helperText.firstItem()
                                                .status(warning)
                                                .text("You must have select a value");
                                    } else if (number == 3) {
                                        fs.validated(success);
                                        helperText.firstItem()
                                                .status(success)
                                                .text("You chose wisely");
                                    } else {
                                        fs.validated(error);
                                        helperText.firstItem()
                                                .status(error)
                                                .text("You must chose Three (thought that was obvious)");
                                    }
                                }, 1234);
                            });
                    return div()
                            .add(form()
                                    .add(formGroup()
                                            .addLabel(formGroupLabel("Comments:"))
                                            .addControl(formGroupControl()
                                                    .addControl(formSelect
                                                            .addOption(formSelectOption("Select a number", "0")
                                                                    .placeholder(true))
                                                            .addOption(formSelectOption("One", "1"))
                                                            .addOption(formSelectOption("Two", "2"))
                                                            .addOption(formSelectOption("Three - the only valid option", "3")))
                                                    .addHelperText(helperText))))
                            .element();
                    // @code-end:form-select-validated
                }));

        addSnippet(new Snippet("form-select-disabled", "Disabled",
                code.get("form-select-disabled"), () -> {
                    // @code-start:form-select-disabled
                    String[] values = { "Mr", "Miss", "Mrs", "Ms", "Dr", "Other" };
                    return div()
                            .add(formSelect("disabled-form-select-0", Id.build("Mrs")).disabled()
                                    .addOption(formSelectOption("Select one").placeholder())
                                    .addOptions(asList(values), FormSelectOption::formSelectOption))
                            .element();
                    // @code-end:form-select-disabled
                }));

        addSnippet(new Snippet("form-select-grouped", "Grouped",
                code.get("form-select-grouped"), () ->
                // @code-start:form-select-grouped
                div()
                        .add(formSelect("disabled-form-select-0", "2")
                                .addGroup(formSelectOptionGroup("Group 1")
                                        .addOption(formSelectOption("The first option", "1"))
                                        .addOption(formSelectOption("Second option is selected by default", "2")))
                                .addGroup(formSelectOptionGroup("Group 2")
                                        .addOption(formSelectOption("The third option", "3"))
                                        .addOption(formSelectOption("The fourth option", "4")))
                                .addGroup(formSelectOptionGroup("Group 3").disabled()
                                        .addOption(formSelectOption("The fifth option", "5"))
                                        .addOption(formSelectOption("The sixth option", "6"))))
                        .element()
        // @code-end:form-select-grouped
        ));
    }
}
