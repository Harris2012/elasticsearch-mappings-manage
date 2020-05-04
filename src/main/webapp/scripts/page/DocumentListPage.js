function DocumentListPage($scope, $stateParams) {
    function watchSuccess(newValue) {
        if (newValue) {
            $scope.success = false;
            $scope.reload = true;
        }
    }
    $scope.clusterId = $stateParams.clusterId;
    $scope.$watch('success', watchSuccess);
}
