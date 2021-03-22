<template>
    <div>
        <cube-tab-bar v-model="selectedLabel" show-slider>
            <cube-tab v-for="item in tabs" :label="item.label" :key="item.label">
            </cube-tab>
        </cube-tab-bar>
        
        <component :videoInfo="videoInfo" :chapterList="chapterList" :is='selectedLabel==="Summary"?"Summary":"Catalog" '>
        </component>
    </div>
</template>

<script>

import Summary from './Summary'
import Catalog from './Catalog'

export default {
    
    components : {
        Summary,
        Catalog
    },

    props : {
        videoInfo : {
            type : Object,
            require : true
        },

        chapterList: {
            type : Array,
            require : true
        }
    },

    data() {
        
        return {
            selectedLabel : "Summary",
            tabs : [
                {
                    label : "Summary"
                }, {
                    label : "Catalog"
                }
            ]
        }
    }


}
</script>