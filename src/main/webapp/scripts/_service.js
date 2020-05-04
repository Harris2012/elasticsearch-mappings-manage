function ElasticsearchManageService($resource, $q, $state) {

    function process(result, d) {
        if (result.status == 401) {
            localStorage["token"] = "";
            $state.go('app.login', {});
        } else {
            d.reject(result);
        }
    }

    var resource = $resource('api', {}, {

        cluster_items: { method: 'POST', url: window.apihost + 'api/cluster/items' },
        cluster_item: { method: 'POST', url: window.apihost + 'api/cluster/item' },
        cluster_basic: { method: 'POST', url: window.apihost + 'api/cluster/basic' },
        cluster_count: { method: 'POST', url: window.apihost + 'api/cluster/count' },
        cluster_update: { method: 'POST', url: window.apihost + 'api/cluster/update' },
        cluster_create: { method: 'POST', url: window.apihost + 'api/cluster/create' },
        cluster_empty: { method: 'POST', url: window.apihost + 'api/cluster/empty' },
        cluster_enable: { method: 'POST', url: window.apihost + 'api/cluster/enable' },
        cluster_disable: { method: 'POST', url: window.apihost + 'api/cluster/disable' },

        document_items: { method: 'POST', url: window.apihost + 'api/document/items' },
        document_item: { method: 'POST', url: window.apihost + 'api/document/item' },
        document_basic: { method: 'POST', url: window.apihost + 'api/document/basic' },
        document_count: { method: 'POST', url: window.apihost + 'api/document/count' },
        document_update: { method: 'POST', url: window.apihost + 'api/document/update' },
        document_create: { method: 'POST', url: window.apihost + 'api/document/create' },
        document_empty: { method: 'POST', url: window.apihost + 'api/document/empty' },
        document_enable: { method: 'POST', url: window.apihost + 'api/document/enable' },
        document_disable: { method: 'POST', url: window.apihost + 'api/document/disable' },

        field_items: { method: 'POST', url: window.apihost + 'api/field/items' },
        field_item: { method: 'POST', url: window.apihost + 'api/field/item' },
        field_basic: { method: 'POST', url: window.apihost + 'api/field/basic' },
        field_count: { method: 'POST', url: window.apihost + 'api/field/count' },
        field_update: { method: 'POST', url: window.apihost + 'api/field/update' },
        field_create: { method: 'POST', url: window.apihost + 'api/field/create' },
        field_empty: { method: 'POST', url: window.apihost + 'api/field/empty' },
        field_enable: { method: 'POST', url: window.apihost + 'api/field/enable' },
        field_disable: { method: 'POST', url: window.apihost + 'api/field/disable' },

        alias_items: { method: 'POST', url: window.apihost + 'api/alias/items' },
        alias_item: { method: 'POST', url: window.apihost + 'api/alias/item' },
        alias_basic: { method: 'POST', url: window.apihost + 'api/alias/basic' },
        alias_count: { method: 'POST', url: window.apihost + 'api/alias/count' },
        alias_update: { method: 'POST', url: window.apihost + 'api/alias/update' },
        alias_create: { method: 'POST', url: window.apihost + 'api/alias/create' },
        alias_empty: { method: 'POST', url: window.apihost + 'api/alias/empty' },
        alias_enable: { method: 'POST', url: window.apihost + 'api/alias/enable' },
        alias_disable: { method: 'POST', url: window.apihost + 'api/alias/disable' },

        metaFieldType_items: { method: 'POST', url: window.apihost + 'api/meta-field-type/items' },
        metaFieldType_selected_item: { method: 'POST', url: window.apihost + 'api/meta-field-type/selected-item' },
        metaFieldType_selected_items: { method: 'POST', url: window.apihost + 'api/meta-field-type/selected-items' },

        mapping_preview: { method: 'POST', url: window.apihost + 'api/mapping/preview' },
        mapping_commit: { method: 'POST', url: window.apihost + 'api/mapping/commit' },

        user_profile: { method: 'POST', url: window.apihost + 'api/user/profile' }
    });

    return {

        cluster_items: function (request) { var d = $q.defer(); resource.cluster_items({}, request, function (result) { d.resolve(result); }, function (result) { process(result, d); }); return d.promise; },
        cluster_item: function (request) { var d = $q.defer(); resource.cluster_item({}, request, function (result) { d.resolve(result); }, function (result) { process(result, d); }); return d.promise; },
        cluster_basic: function (request) { var d = $q.defer(); resource.cluster_basic({}, request, function (result) { d.resolve(result); }, function (result) { process(result, d); }); return d.promise; },
        cluster_update: function (request) { var d = $q.defer(); resource.cluster_update({}, request, function (result) { d.resolve(result); }, function (result) { process(result, d); }); return d.promise; },
        cluster_count: function (request) { var d = $q.defer(); resource.cluster_count({}, request, function (result) { d.resolve(result); }, function (result) { process(result, d); }); return d.promise; },
        cluster_create: function (request) { var d = $q.defer(); resource.cluster_create({}, request, function (result) { d.resolve(result); }, function (result) { process(result, d); }); return d.promise; },
        cluster_empty: function (request) { var d = $q.defer(); resource.cluster_empty({}, request, function (result) { d.resolve(result); }, function (result) { process(result, d); }); return d.promise; },
        cluster_enable: function (request) { var d = $q.defer(); resource.cluster_enable({}, request, function (result) { d.resolve(result); }, function (result) { process(result, d); }); return d.promise; },
        cluster_disable: function (request) { var d = $q.defer(); resource.cluster_disable({}, request, function (result) { d.resolve(result); }, function (result) { process(result, d); }); return d.promise; },

        document_items: function (request) { var d = $q.defer(); resource.document_items({}, request, function (result) { d.resolve(result); }, function (result) { process(result, d); }); return d.promise; },
        document_item: function (request) { var d = $q.defer(); resource.document_item({}, request, function (result) { d.resolve(result); }, function (result) { process(result, d); }); return d.promise; },
        document_basic: function (request) { var d = $q.defer(); resource.document_basic({}, request, function (result) { d.resolve(result); }, function (result) { process(result, d); }); return d.promise; },
        document_update: function (request) { var d = $q.defer(); resource.document_update({}, request, function (result) { d.resolve(result); }, function (result) { process(result, d); }); return d.promise; },
        document_count: function (request) { var d = $q.defer(); resource.document_count({}, request, function (result) { d.resolve(result); }, function (result) { process(result, d); }); return d.promise; },
        document_create: function (request) { var d = $q.defer(); resource.document_create({}, request, function (result) { d.resolve(result); }, function (result) { process(result, d); }); return d.promise; },
        document_empty: function (request) { var d = $q.defer(); resource.document_empty({}, request, function (result) { d.resolve(result); }, function (result) { process(result, d); }); return d.promise; },
        document_enable: function (request) { var d = $q.defer(); resource.document_enable({}, request, function (result) { d.resolve(result); }, function (result) { process(result, d); }); return d.promise; },
        document_disable: function (request) { var d = $q.defer(); resource.document_disable({}, request, function (result) { d.resolve(result); }, function (result) { process(result, d); }); return d.promise; },

        field_items: function (request) { var d = $q.defer(); resource.field_items({}, request, function (result) { d.resolve(result); }, function (result) { process(result, d); }); return d.promise; },
        field_item: function (request) { var d = $q.defer(); resource.field_item({}, request, function (result) { d.resolve(result); }, function (result) { process(result, d); }); return d.promise; },
        field_basic: function (request) { var d = $q.defer(); resource.field_basic({}, request, function (result) { d.resolve(result); }, function (result) { process(result, d); }); return d.promise; },
        field_update: function (request) { var d = $q.defer(); resource.field_update({}, request, function (result) { d.resolve(result); }, function (result) { process(result, d); }); return d.promise; },
        field_count: function (request) { var d = $q.defer(); resource.field_count({}, request, function (result) { d.resolve(result); }, function (result) { process(result, d); }); return d.promise; },
        field_create: function (request) { var d = $q.defer(); resource.field_create({}, request, function (result) { d.resolve(result); }, function (result) { process(result, d); }); return d.promise; },
        field_empty: function (request) { var d = $q.defer(); resource.field_empty({}, request, function (result) { d.resolve(result); }, function (result) { process(result, d); }); return d.promise; },
        field_enable: function (request) { var d = $q.defer(); resource.field_enable({}, request, function (result) { d.resolve(result); }, function (result) { process(result, d); }); return d.promise; },
        field_disable: function (request) { var d = $q.defer(); resource.field_disable({}, request, function (result) { d.resolve(result); }, function (result) { process(result, d); }); return d.promise; },

        alias_items: function (request) { var d = $q.defer(); resource.alias_items({}, request, function (result) { d.resolve(result); }, function (result) { process(result, d); }); return d.promise; },
        alias_item: function (request) { var d = $q.defer(); resource.alias_item({}, request, function (result) { d.resolve(result); }, function (result) { process(result, d); }); return d.promise; },
        alias_basic: function (request) { var d = $q.defer(); resource.alias_basic({}, request, function (result) { d.resolve(result); }, function (result) { process(result, d); }); return d.promise; },
        alias_update: function (request) { var d = $q.defer(); resource.alias_update({}, request, function (result) { d.resolve(result); }, function (result) { process(result, d); }); return d.promise; },
        alias_count: function (request) { var d = $q.defer(); resource.alias_count({}, request, function (result) { d.resolve(result); }, function (result) { process(result, d); }); return d.promise; },
        alias_create: function (request) { var d = $q.defer(); resource.alias_create({}, request, function (result) { d.resolve(result); }, function (result) { process(result, d); }); return d.promise; },
        alias_empty: function (request) { var d = $q.defer(); resource.alias_empty({}, request, function (result) { d.resolve(result); }, function (result) { process(result, d); }); return d.promise; },
        alias_enable: function (request) { var d = $q.defer(); resource.alias_enable({}, request, function (result) { d.resolve(result); }, function (result) { process(result, d); }); return d.promise; },
        alias_disable: function (request) { var d = $q.defer(); resource.alias_disable({}, request, function (result) { d.resolve(result); }, function (result) { process(result, d); }); return d.promise; },

        metaFieldType_items: function (request) { var d = $q.defer(); resource.metaFieldType_items({}, request, function (result) { d.resolve(result); }, function (result) { process(result, d); }); return d.promise; },
        metaFieldType_selected_item: function (request) { var d = $q.defer(); resource.metaFieldType_selected_item({}, request, function (result) { d.resolve(result); }, function (result) { process(result, d); }); return d.promise; },
        metaFieldType_selected_items: function (request) { var d = $q.defer(); resource.metaFieldType_selected_items({}, request, function (result) { d.resolve(result); }, function (result) { process(result, d); }); return d.promise; },

        mapping_preview: function (request) { var d = $q.defer(); resource.mapping_preview({}, request, function (result) { d.resolve(result); }, function (result) { process(result, d); }); return d.promise; },
        mapping_commit: function (request) { var d = $q.defer(); resource.mapping_commit({}, request, function (result) { d.resolve(result); }, function (result) { process(result, d); }); return d.promise; },

        user_profile: function (request) { var d = $q.defer(); resource.user_profile({}, request, function (result) { d.resolve(result); }, function (result) { process(result, d); }); return d.promise; }
    }
}
