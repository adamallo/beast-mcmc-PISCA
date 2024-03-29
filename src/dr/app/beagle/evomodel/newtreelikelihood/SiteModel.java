/*
 * SiteModel.java
 *
 * Copyright (c) 2002-2015 Alexei Drummond, Andrew Rambaut and Marc Suchard
 *
 * This file is part of BEAST.
 * See the NOTICE file distributed with this work for additional
 * information regarding copyright ownership and licensing.
 *
 * BEAST is free software; you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 *  BEAST is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with BEAST; if not, write to the
 * Free Software Foundation, Inc., 51 Franklin St, Fifth Floor,
 * Boston, MA  02110-1301  USA
 */

package dr.app.beagle.evomodel.newtreelikelihood;

import dr.inference.model.Model;

/**
 * SiteRateModel - Specifies how rates vary across sites. Unlike 'SiteModel'
 * this only deals with rates for site categories.
 *
 * @author Andrew Rambaut
 * @author Alexei Drummond
 *
 * @version $Id: SiteModel.java,v 1.77 2005/05/24 20:25:58 rambaut Exp $
 */

public interface SiteModel extends Model {

	/**
	 * @return the number of categories of substitution processes
	 */
	int getCategoryCount();

    /**
     * Get an array of the relative rates of sites in each category. These
     * may include the 'mu' parameter, an overall scaling of the siteModel.
     * @return an array of the rates.
     */
    double[] getCategoryRates();

	/**
	 * Get an array of the expected proportion of sites in each category.
	 * @return an array of the proportions.
	 */
	double[] getCategoryProportions();

    /**
     * Get the rate for a particular category. This may include the 'mu'
     * parameter, an overall scaling of the siteModel.
     * @param category the category number
     * @return the rate.
     */
    double getRateForCategory(int category);

    /**
     * Get the expected proportion of sites in this category.
     * @param category the category number
     * @return the proportion.
     */
    double getProportionForCategory(int category);


}