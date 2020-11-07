#  Efficient database👨🏽‍💻👨🏽‍💻

This project is based on the creation of a database with an estimated figure of the population of the American continent (one billion people).
The data used for the creation of records are:
***code, name, surname, sex, date of birth, height, nationality and photograph.***

> 🔴The solution is implemented with an AVL tree as the main data structure. The solution is implemented with an AVL tree as the main data structure. 🔴

### Problem solution✔️:

The developed program creates the records mentioned above under the following conditions:

- The datasets that the program uses as input to generate people's data are downloaded to a project directory (/ data).

	- For data generation, the names are taken from [here](https://data.world/alexandra/baby-names "here")
	-  For data generation, the surnames are taken from [here](https://data.world/uscensusbureau/frequently-occurring-surnames-from-the-census-2010 "here")
  
- The date of birth is generated randomly, assuming an age distribution based on [this United States age distribution.](https://www.indexmundi.com/es/estados_unidos/distribucion_por_edad.html "this United States age distribution.") The sex distribution is ignored. The number of men and women is equal.

- The height of the people is randomly generated.
- Nationality is generated for each person, in such a way as to maintain the real population percentages of each country with respect to the continent according to [these population data by country](https://www.kaggle.com/tanuprabhu/population-by-country-2020 "these population data by country")

## DOCUMENTATION 📋📋

Documentation about the project can be found [here](https://github.com/StivenArboleda/efficient-database-management/blob/main/docs/Engineering_method.pdf "here").
