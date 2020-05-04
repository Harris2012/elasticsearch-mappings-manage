function DocumentPreviewModal($scope, $uibModalInstance, ElasticsearchManageService, id, clusterId) {

    $scope.id = id;

    $scope.clusterId = clusterId;

    $scope.closeModal = function () {
        $uibModalInstance.dismiss("cancel");
    }

    function mapping_preview_callback(response) {
        if (response.status != 1) {
            return;
        }
        $scope.content = response.content;
    }

    function mapping_commit_callback(response) {
        if (response.status != 1) {
            swal(response.message);
            return;
        }
        swal("推送成功");
    }

    $scope.commit = function () {
        var request = {};
        request.clusterId = $scope.clusterId;
        request.documentId = $scope.id;
        ElasticsearchManageService.mapping_commit(request).then(mapping_commit_callback);
    }

    {
        var request = {};
        request.clusterId = $scope.clusterId;
        request.documentId = $scope.id;
        ElasticsearchManageService.mapping_preview(request).then(mapping_preview_callback);
    }
}
