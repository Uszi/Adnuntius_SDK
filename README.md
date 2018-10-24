# Adnuntius Mobile SDK

Adnuntius Mobile SDK (AMSDK) is a sdk which allows business partner to embed Adnuntius ads in thier native mobile applications. AMSDK works on:

  - iOS
  - Android

### iOS features

  - Load ad from script
  - Load ad from API
### Android features
  - Load ad from script


# Integration

### iOS
[logo]: https://i.imgsafe.org/79/799e4a08ca.png
- In your Xcode project add Adnuntius.framework as a Linked Framework
![logo]

- In your `AppDelegate` file add header and configuration code:
```js
import AdnuntiusSDK
```
```swift
    AdnuntiusSDK.config = ["siteId": "1131763067966473843",
                           "adUnits": [
                            ["auId": "0000000000000fe6", "c": ["sports"]],
                                        ["auId": "0000000000000fe6", "c": ["sports"]]]]
    AdnuntiusSDK.adScript =
    """
        <html>
        <head />
        <body>
        <div id="adn-0000000000000fe6" style="display:none"></div>
        <script type="text/javascript">(function(d, s, e, t) { e = d.createElement(s); e.type = 'text/java' + s; e.async = 'async'; e.src = 'http' + ('https:' === location.protocol ? 's' : '') + '://cdn.adnuntius.com/adn.js'; t = d.getElementsByTagName(s)[0]; t.parentNode.insertBefore(e, t); })(document, 'script');window.adn = window.adn || {}; adn.calls = adn.calls || []; adn.calls.push(function() { adn.request({ adUnits: [ {auId: '0000000000000fe6', auW: 320, auH: 480 } ]}); });</script>
        </body>
        </html>
    """
```
- Integrate it with your view for example:
```js
// Adnuntius injector
    if (indexPath.row % 4 == 0) {
        if let preCell = adCells?[indexPath.row] {
            debugPrint("preCell")
            return preCell
        }
        let cell = UITableViewCell()
        let webView = AdnuntiusAdWebView(frame: CGRect(x: 0, y: 10, width: tableView.frame.width, height: 100))
        webView.delegate = self
        cell.contentView.addSubview(webView)
        cell.contentView.sizeToFit()
        adCells?[indexPath.row] = cell
        return cell
    }
```
### Android
- Add module `lib-release.aar` to your project
- In `MainActivity` inside method `OnCreate` inject Adnuntius config script
```java
AdView.adScript = "<html>\n" +
                "        <head />\n" +
                "        <body>\n" +
                "        <div id=\"adn-0000000000000fe6\" style=\"display:none\"></div>\n" +
                "        <script type=\"text/javascript\">(function(d, s, e, t) { e = d.createElement(s); e.type = 'text/java' + s; e.async = 'async'; e.src = 'http' + ('https:' === location.protocol ? 's' : '') + '://cdn.adnuntius.com/adn.js'; t = d.getElementsByTagName(s)[0]; t.parentNode.insertBefore(e, t); })(document, 'script');window.adn = window.adn || {}; adn.calls = adn.calls || []; adn.calls.push(function() { adn.request({ adUnits: [ {auId: '0000000000000fe6', auW: 320, auH: 480 } ]}); });</script>\n" +
                "        </body>\n" +
                "        </html>";
```
- Add implementation inside your xml layout file:
```xml
<com.adnuntius.sdk.lib.AdView
        android:id="@+id/facebookWebview"
        android:layout_width="354dp"
        android:layout_height="244dp"
        android:layout_alignBottom="@+id/swipeRefreshLayout"
        android:layout_centerHorizontal="true"
        tools:ignore="MissingConstraints" />
```

- To update SDK copy and paste newer version inside lib-release folder in your project
