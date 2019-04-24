		window.alert = alert;
        function alert(data) {
            var a = document.createElement("div"),
                title = document.createElement("p"),
                content = document.createElement("p"),
                btn = document.createElement("div"),
                textNode = document.createTextNode(data ? data : ""),
                btnText = document.createTextNode("确定");
            // 控制样式
            css(a, {
                "width" : "430px",
                "height" : "120px",
                "border": "1px solid #000",
                "margin" : "0 auto",
                "position" : "fixed",
                "z-index":"9999999",
                "display" : "block"
            });
            css(btn, {
                "background-color": "#008CBA",
                "border": "none",
                "color": "white",
                "padding": "8px 28px",
                "text-align": "center",
                "text-decoration": "none",
                "display": "inline-block",
                "font-size": "8px",
                "float" : "right"
            });
            css(title, {
                "font-size" : "18px",
                "width" : "250px",
                "height" : "20px"
            });
            css(content, {
                "font-size" : "14px",
                "width" : "250px",
                "height" : "20px",
                "text-align": "center"
            })

            // 内部结构套入
            title.appendChild(document.createTextNode("友情提示："));
            content.appendChild(textNode);
            btn.appendChild(btnText);
            a.appendChild(title);
            a.appendChild(content);
            a.appendChild(btn);
            // 整体显示到页面内
            document.getElementsByTagName("body")[0].appendChild(a);

            // 确定绑定点击事件删除标签
            btn.onclick = function() {
                a.parentNode.removeChild(a);
            }
        }
        function css(targetObj, cssObj) {
            var str = targetObj.getAttribute("style") ? targetObj.getAttribute("style") : "";
            for(var i in cssObj) {
                str += i + ":" + cssObj[i] + ";";
            }
            targetObj.style.cssText = str;
        }