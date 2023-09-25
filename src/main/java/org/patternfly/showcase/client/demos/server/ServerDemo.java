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
package org.patternfly.showcase.client.demos.server;

import org.patternfly.components.DataTable;
import org.patternfly.dataprovider.DataProvider;
import org.patternfly.showcase.client.Data;
import org.patternfly.showcase.client.Page;

import elemental2.dom.HTMLElement;

import static java.util.Arrays.asList;
import static java.util.Comparator.comparing;
import static org.jboss.elemento.Elements.p;
import static org.patternfly.components.Content.content;
import static org.patternfly.components.DataTable.checkboxColumn;
import static org.patternfly.components.DataTable.column;
import static org.patternfly.components.DataTable.dataTable;
import static org.patternfly.components.page.PageMainSection.pageMainSection;
import static org.patternfly.components.title.Title.title;
import static org.patternfly.layout.Size._4xl;

public class ServerDemo implements Page {

    private final Iterable<HTMLElement> elements;

    public ServerDemo() {
        DataProvider<Server> dataProvider = new DataProvider<>(server -> server.name);
        DataTable<Server> dataTable = dataTable(dataProvider).add(checkboxColumn())
                .add(column("Name", comparing(server -> server.name), (td, dp, server) -> td.textContent(server.name)))
                .add(column("Threads", comparing(server -> server.threads),
                        (td, dp, server) -> td.textContent(String.valueOf(server.threads))))
                .add(column("Applications", comparing(server -> server.applications),
                        (td, dp, server) -> td.textContent(String.valueOf(server.applications))))
                .add(column("Workspaces", comparing(server -> server.workspaces),
                        (td, dp, server) -> td.textContent(String.valueOf(server.workspaces))))
                .add(column("Status", comparing(Server::status),
                        (td, dp, server) -> td.textContent(server.status().name().toLowerCase())))
                .add(column("Location", comparing(server -> server.location),
                        (td, dp, server) -> td.textContent(server.location)));

        dataProvider.bindDisplay(dataTable);
        dataProvider.update(Data.servers);

        elements = asList(
                pageMainSection()
                        .add(content().add(title(1, "Servers", _4xl))
                                .add(p().add("Filter servers based on user input.")))
                        .element(),
                pageMainSection()
                        // .add(toolbar)
                        .add(dataTable)
                        .element());
    }

    @Override
    public Iterable<HTMLElement> elements() {
        return elements;
    }
}
