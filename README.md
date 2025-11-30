# Como mudar a cor acima da toolbar

Para alterar a cor da área acima da toolbar no seu editor (como VS
Code), siga os passos abaixo:

## 1. Abra as configurações JSON

1.  Pressione **Ctrl + Shift + P**\
2.  Digite **Preferences: Open User Settings (JSON)**\
3.  Pressione **Enter**

## 2. Adicione ou edite o bloco de cores

Inclua no seu `settings.json` o seguinte trecho:

``` json
"workbench.colorCustomizations": {
    "titleBar.activeBackground": "#1E1E1E",
    "titleBar.inactiveBackground": "#2D2D2D",
    "titleBar.activeForeground": "#FFFFFF",
    "titleBar.inactiveForeground": "#CCCCCC",
    "menu.background": "#1E1E1E"
}
```

## 3. Salve o arquivo

As alterações serão aplicadas imediatamente.

## Observação

-   Você pode substituir as cores por qualquer valor hexadecimal.
-   Caso esteja usando um tema que controla essas cores, talvez precise
    permitir overrides via `workbench.colorCustomizations`.

------------------------------------------------------------------------
<img width="1393" height="689" alt="image" src="https://github.com/user-attachments/assets/afa2b565-f537-45b5-97e7-ba05a3f0869f" />

Se quiser personalizar ainda mais, posso gerar configurações completas
para você.
