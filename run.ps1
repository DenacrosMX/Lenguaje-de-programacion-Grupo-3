Set-StrictMode -Version Latest
$ErrorActionPreference = "Stop"

$projectRoot = Split-Path -Parent $MyInvocation.MyCommand.Path
$scalaDir = Join-Path $projectRoot "ArtesLuisStudio-Scala"
$javaExe = "C:\Program Files\Eclipse Adoptium\jdk-17.0.16.8-hotspot\bin\java.exe"
$sbtJar = Join-Path $scalaDir "sbt-launch.jar"

if (-not (Test-Path -Path $javaExe)) {
  throw "No se encontro java.exe en: $javaExe"
}

if (-not (Test-Path -Path $sbtJar)) {
  throw "No se encontro sbt-launch.jar en: $sbtJar"
}

Push-Location $scalaDir
try {
  & $javaExe -jar $sbtJar run
} finally {
  Pop-Location
}
