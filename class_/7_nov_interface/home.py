from taipy.gui import Gui
from PIL import Image

# HTML content
html_content = """
<h1 style='text-align: center; color: red;'>Sustainable Products Customization Web App</h1>
<h1 style='text-align: center; color: blue;'>ECO-FRIENDLY PRODUCT RECOMMENDATION ENGINE</h1>
"""

# Optional: Load and display an image (uncomment if needed and specify the correct path)
# image_path = "gdsc_aum.jpg"
# image = Image.open(image_path)

# Create the layout with HTML content
layout = """
<|{html_content}|raw|>
<|Image|file=image_path|width=500|>
"""

# Initialize and run the Taipy GUI with the HTML layout
Gui(page=layout).run()
