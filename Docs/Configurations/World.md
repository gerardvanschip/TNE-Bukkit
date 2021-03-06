World Configurations
======================
As of TNE Alpha 3.2 servers owners have the ability to set every configuration on a per-world basis.

File
--------------
worlds.yml

Configuration
--------------
```YAML
# All configurations that can be made world-specific
# To use, please check the Example world below
Worlds:

    #An example of what world-specific configurations are available
    #Please note that you do NOT have to include all the following configurations as all
    #world-specific configurations are optional
    #Note: World name is case sensitive
    Example:

        #Whether or not to completely disable economy features for this world
        DisableEconomy: true
        
        #How much it costs to enter this world if ChangeFee is enabled in the main configuration
        ChangeFee: 10.0

        #Configurations related to information sharing between worlds
        Share:

          #If you want to share balances with another world.
          Balances: worldname

          #If you want to share configurations with another world
          Configurations: worldname
        
        #All configurations relating to currency.
        Currency:

          #Name of the currency
          Default:

            #The format to use when outputting this currency into chat.
            #The variables you're able to use here.
            #<symbol> - The currency's symbol
            #<decimal> - The currency's decimal.
            #<major> - A combination of the currency's major amount and name
            #<minor> - A combination of the currency's minor amount and name
            #<major.name> - The currency's major name.
            #<minor.name> - The currency's minor name.
            #<major.amount> - The currency's major amount.
            #<minor.amount> - The currency's minor amount.
            #<short.amount> - The currency's shortened amount.
            #<shorten> - Added to make the outputted value shortened
            # If shortened, it will ignore the value of Format.
            #It's also possible to include all colour variables from messages.yml
            #Example: <major> and <minor>
            Format: <symbol><major><decimal><minor><shorten>

            #The initial balance for accounts.
            #Will be used if no world-specific configurations are found if multiworld is enabled
            Balance: 200.0

            #Whether or not this currency is the world's default.
            Default: true

            #The conversion power of this currency to other currencies.
            #This is based on a decimal conversion system where 1.0 is 100% i.e. the "normal" rate
            Conversion: 1.0

            #The character to use as the symbol for this currency.
            Symbol: '$'

            #The character to use as the decimal place holder.
            Decimal: .

            #Would you like to use an item as the currency?
            ItemCurrency: false

            #If you want to use an item, which one?(Please use the name of the item)
            #Example: GOLD_INGOT
            ItemMajor: GOLD_INGOT

            #The minor item currency item.
            #Example: for USD this might be quarters or dimes
            ItemMinor: IRON_INGOT

            #The name of the major currency
            #Example: Dollars
            MajorName:

                #The singular name. Example: Dollar
                Single: Dollar

                #The plural name. Example: Dollars
                Plural: Dollars

            #The name of the minor currency
            #Example: Cents
            MinorName:

                #The singular name. Example: Cent
                Single: Cent

                #The plural name. Example: Cents
                Plural: Cents
```