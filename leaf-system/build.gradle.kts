
dependencies {
    implementation(libs.jimmer.quarkus)
    annotationProcessor(libs.jimmer.apt)
    implementation(project(":leaf-framework"))
    testImplementation(libs.bundles.quarkus.test)
}