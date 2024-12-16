### Classes

#### Plan
- **Attributes:**
  - Plan ID
  - Plan Name
  - Plan Price

#### Service Provider
- **Attributes:**
  - Sp ID
  - Sp Name
  - List of Plans (`<Plan>`)

#### Mobile
- **Attributes:**
  - Mobile ID
  - Mobile Brand
  - Mobile Price
  - Service Provider (`<ServiceProvider>`)

### Requirements
1. **Generate Getters and Setters**
   - Implement getters and setters for all attributes.
2. **Parameterized Constructors**
   - Create constructors that initialize all attributes.

### Methods in `MobileService`

#### `getMobileBrandWithPlansGreaterThanNThreshold()`
- **Parameters:**
  - `List<Mobile>`: List of mobile objects.
  - `int threshold`: Minimum number of plans.
- **Functionality:**
  - Identify mobile brands where the associated service provider has a number of plans greater than or equal to the threshold.
  - **Returns:** `List<String>` of matching mobile brand names.

#### `groupPlansBasedOnServiceProvider()`
- **Parameters:**
  - `List<Mobile>`: List of mobile objects.
- **Functionality:**
  - Group plans based on the service provider name.
  - Ensure that duplicate service provider names are avoided if multiple mobiles share the same service provider.
  - **Returns:** A mapping (`Map<String, List<Plan>>`) where the key is the service provider name and the value is the list of plans associated with that provider.

### Solution Class
- Implement the above functions in a `Solution` class.
- Write a `main()` method to test the implementation with sample data.
