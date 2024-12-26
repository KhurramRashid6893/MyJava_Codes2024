from taipy.gui import Gui, notify
import pandas as pd
from sklearn.model_selection import train_test_split
from sklearn.ensemble import RandomForestClassifier
from sklearn.preprocessing import LabelEncoder

# Load and preprocess data
df = pd.read_csv("eco_friendly_product5.csv")

# Fill missing values and map columns
df["Compliance_with_Standards"] = df["Compliance_with_Standards"].fillna("ISO 14001")
df["Certification"] = df["Certification"].fillna("Energy Star")

mapping = {'Partially Sustainable': 0, 'Non-Sustainable': 1, 'Sustainable': 2}
df['Resource_Sourcing'] = df['Resource_Sourcing'].map(mapping)

impact_mapping = {'low': 0, 'medium': 1, 'high': 2}
df['Manufacturing_Impact'] = df['Manufacturing_Impact'].str.lower().str.strip().map(impact_mapping)

preference_mapping = {
    'Energy Efficient': 0,
    'Organic': 1,
    'Eco-Certified': 2,
    'Recyclable': 3,
    'Low Carbon': 4
}
df['User_Preference'] = df['User_Preference'].map(preference_mapping)

# Define features and target
feature_columns = ['Carbon_Footprint_kgCO2e', 'Water_Usage_Liters', 'Manufacturing_Impact', 'Price_Range_USD']
X = df[feature_columns]
y = df['Resource_Sourcing']

# Encode categorical variables
le = LabelEncoder()
df['Manufacturing_Impact'] = le.fit_transform(df['Manufacturing_Impact'])
df['Resource_Sourcing'] = le.fit_transform(df['Resource_Sourcing'])

# Train the Random Forest model
X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.2, random_state=42)
rf_model = RandomForestClassifier().fit(X_train, y_train)

# Define prediction function
def predict_resource_sourcing():
    global prediction, sustainability_status, filtered_products
    inputs = pd.DataFrame([[carbon_footprint, water_usage, manufacturing_impact, price_range]], columns=feature_columns)
    inputs['Manufacturing_Impact'] = [manufacturing_impact]
    prediction = rf_model.predict(inputs)[0]
    sustainability_status = ["Partially Sustainable", "Non-Sustainable", "Sustainable"][prediction]
    
    # Display recommended products based on sustainability
    filtered_products = df[df['Resource_Sourcing'] == prediction][['Product_Name', 'Category', 'Brand', 'Availability']]

# Define default values and user input variables
carbon_footprint = 0.0
water_usage = 0
manufacturing_impact = 0  # Corresponds to 'low'
price_range = 5.0
sustainability_status = ""
filtered_products = pd.DataFrame()

# Taipy page layout
layout = """
# ECO-FRIENDLY PRODUCT RECOMMENDATION SYSTEM 🌍

This tool predicts the sustainability level of a product based on environmental characteristics.

<|layout|columns=1 1|>
<|{carbon_footprint}|slider|min=0|max=100|step=0.5|label=Carbon Footprint (kgCO2e)|>
<|{water_usage}|slider|min=0|max=200|step=10|label=Water Usage (Liters)|>
<|{manufacturing_impact}|selector|lov={('Low', 0), ('Medium', 1), ('High', 2)}|label=Manufacturing Impact|>
<|{price_range}|slider|min=5|max=500|step=10|label=Price Range (USD)|>
<|layout>

<|Predict Sustainability|button|on_action=predict_resource_sourcing|>

<|part|class_name=success|condition=sustainability_status|>
### Predicted Sustainability Status: **<|{sustainability_status}|>**
<|part>

<|part|condition=len(filtered_products) > 0|>
### Recommended Products:
<|{filtered_products}|table|>
<|part>

Powered by Machine Learning models for eco-conscious choices!
"""

# Run the Taipy GUI
Gui(page=layout).run()
