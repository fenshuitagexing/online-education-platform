
>> `vue create online_classroom_front`
? Please pick a preset: Manually select features
? Check the features needed for your project: 
 ◉ Choose Vue version
 ◉ Babel
 ◯ TypeScript
 ◯ Progressive Web App (PWA) Support
 ◉ Router
 ◉ Vuex
❯◉ CSS Pre-processors
 ◯ Linter / Formatter
 ◯ Unit Testing
 ◯ E2E Testing

choose [Manually select features]
choose [Babel], [Router], [Vuex], [CSS Pre-processors] by pressing Space

? Choose a version of Vue.js that you want to start the project with [2.x]

? Use history mode for router? (Requires proper server setup for index fallback in pro
duction) (Y/n) [n]

? Pick a CSS pre-processor (PostCSS, Autoprefixer and CSS Modules are supported by def
ault): (Use arrow keys)
❯ Sass/SCSS (with dart-sass) 
  Sass/SCSS (with node-sass) 
  Less 
  Stylus 
[Enter]

? Where do you prefer placing config for Babel, ESLint, etc.? (Use arrow keys)
❯ In dedicated config files 
  In package.json 
[Enter]

? Save this as a preset for future projects? (y/N) [N]



cd into the project folder:
>> `cnpm install axios --save`

Check the package.json, 
```
"dependencies": {
    "axios": "^0.21.1",
    "core-js": "^3.6.5",
    "vue": "^2.6.11",
    "vue-router": "^3.2.0",
    "vuex": "^3.4.0"
  }
```
this code snippet shows axios is added into dependencies of `package.json`

>> `vue add cube-ui`
Press [Enter] for next steps

>> `cnpm install`
For producing `node_modules` directory in VS Code


