/*
 * Copyright (c) 2013 M-Way Solutions GmbH
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jenkinsci.plugins.relution_publisher.constants;

import hudson.util.ListBoxModel;
import hudson.util.ListBoxModel.Option;


/**
 * Indicates the release status of a build artifact.
 * <p/>
 * The release status of an application defines who will be able to access the application. A
 * version with status <code>Development<code> will be shown as a development version and is
 * usually only available to developers. A version uploaded to <code>Review</code> is available
 * to reviewers, while a version uploaded as <code>Release</code> is available to end users.
 * <p/>
 * By default applications are be uploaded to <code>Development</code> and must be manually
 * moved to <code>Review</code> by a developer, to make this version available for review. The
 * version is then manually moved to <code>Release</code> by a reviewer if the version has passed
 * review and should replace the currently released version.
 * <p/>
 * Changing the release status for an application allows to skip parts of this manual process,
 * i.e. if the application is not reviewed/tested by a human.
 */
public final class ReleaseStatus {

    /**
     * Versions produced by the build process should be uploaded to <code>Development</code>.
     */
    public final static ReleaseStatus DEVELOPMENT = new ReleaseStatus("DEVELOPMENT", "Development");

    /**
     * Versions produces by the build process should be uploaded to <code>Review</code>
     */
    public final static ReleaseStatus REVIEW      = new ReleaseStatus("REVIEW", "Review");

    /**
     * Versions produced by the build process should be uploaded to <code>Release</code>
     */
    public final static ReleaseStatus RELEASE     = new ReleaseStatus("RELEASE", "Release");

    /**
     * The key for the release status.
     */
    public final String               key;

    /**
     * The display name for the release status.
     */
    public final String               name;

    private Option                    option;

    private ReleaseStatus(final String key, final String name) {

        this.key = key;
        this.name = name;
    }

    /**
     * Converts the {@link ReleaseStatus} to a a drop down item for a {@link ListBoxModel}.
     * @return An {@link Option}.
     */
    public Option asOption() {

        if (this.option == null) {
            this.option = new Option(this.name, this.key);
        }
        return this.option;
    }

    /**
     * Adds all available {@link ReleaseStatus} items to the specified list box as drop down items.
     * @param list The {@link ListBoxModel} to which the items should be added.
     */
    public static void fillListBox(final ListBoxModel list) {

        list.add(0, DEVELOPMENT.asOption());
        list.add(1, REVIEW.asOption());
        list.add(2, RELEASE.asOption());
    }
}
