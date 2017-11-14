/* 001 */ public Object generate(Object[] references) {
/* 002 */   return new GeneratedIterator(references);
/* 003 */ }
/* 004 */
/* 005 */ final class GeneratedIterator extends org.apache.spark.sql.execution.BufferedRowIterator {
/* 006 */   private Object[] references;
/* 007 */   private scala.collection.Iterator[] inputs;
/* 008 */   private scala.collection.Iterator smj_leftInput;
/* 009 */   private scala.collection.Iterator smj_rightInput;
/* 010 */   private InternalRow smj_leftRow;
/* 011 */   private InternalRow smj_rightRow;
/* 012 */   private UTF8String smj_value2;
/* 013 */   private java.util.ArrayList smj_matches;
/* 014 */   private UTF8String smj_value3;
/* 015 */   private UTF8String smj_value4;
/* 016 */   private boolean smj_isNull2;
/* 017 */   private long smj_value5;
/* 018 */   private boolean smj_isNull3;
/* 019 */   private long smj_value6;
/* 020 */   private boolean smj_isNull4;
/* 021 */   private org.apache.spark.sql.execution.metric.SQLMetric smj_numOutputRows;
/* 022 */   private UnsafeRow smj_result;
/* 023 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder smj_holder;
/* 024 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter smj_rowWriter;
/* 025 */   private UnsafeRow project_result;
/* 026 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 027 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 028 */
/* 029 */   public GeneratedIterator(Object[] references) {
/* 030 */     this.references = references;
/* 031 */   }
/* 032 */
/* 033 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 034 */     partitionIndex = index;
/* 035 */     this.inputs = inputs;
/* 036 */     smj_leftInput = inputs[0];
/* 037 */     smj_rightInput = inputs[1];
/* 038 */
/* 039 */     smj_rightRow = null;
/* 040 */
/* 041 */     smj_matches = new java.util.ArrayList();
/* 042 */
/* 043 */     this.smj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[0];
/* 044 */     smj_result = new UnsafeRow(5);
/* 045 */     this.smj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(smj_result, 64);
/* 046 */     this.smj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(smj_holder, 5);
/* 047 */     project_result = new UnsafeRow(8);
/* 048 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 64);
/* 049 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 8);
/* 050 */
/* 051 */   }
/* 052 */
/* 053 */   private boolean findNextInnerJoinRows(
/* 054 */     scala.collection.Iterator leftIter,
/* 055 */     scala.collection.Iterator rightIter) {
/* 056 */     smj_leftRow = null;
/* 057 */     int comp = 0;
/* 058 */     while (smj_leftRow == null) {
/* 059 */       if (!leftIter.hasNext()) return false;
/* 060 */       smj_leftRow = (InternalRow) leftIter.next();
/* 061 */
/* 062 */       boolean smj_isNull = smj_leftRow.isNullAt(0);
/* 063 */       UTF8String smj_value = smj_isNull ? null : (smj_leftRow.getUTF8String(0));
/* 064 */       if (smj_isNull) {
/* 065 */         smj_leftRow = null;
/* 066 */         continue;
/* 067 */       }
/* 068 */       if (!smj_matches.isEmpty()) {
/* 069 */         comp = 0;
/* 070 */         if (comp == 0) {
/* 071 */           comp = smj_value.compare(smj_value3);
/* 072 */         }
/* 073 */
/* 074 */         if (comp == 0) {
/* 075 */           return true;
/* 076 */         }
/* 077 */         smj_matches.clear();
/* 078 */       }
/* 079 */
/* 080 */       do {
/* 081 */         if (smj_rightRow == null) {
/* 082 */           if (!rightIter.hasNext()) {
/* 083 */             smj_value3 = smj_value.clone();
/* 084 */             return !smj_matches.isEmpty();
/* 085 */           }
/* 086 */           smj_rightRow = (InternalRow) rightIter.next();
/* 087 */
/* 088 */           boolean smj_isNull1 = smj_rightRow.isNullAt(0);
/* 089 */           UTF8String smj_value1 = smj_isNull1 ? null : (smj_rightRow.getUTF8String(0));
/* 090 */           if (smj_isNull1) {
/* 091 */             smj_rightRow = null;
/* 092 */             continue;
/* 093 */           }
/* 094 */           smj_value2 = smj_value1.clone();
/* 095 */         }
/* 096 */
/* 097 */         comp = 0;
/* 098 */         if (comp == 0) {
/* 099 */           comp = smj_value.compare(smj_value2);
/* 100 */         }
/* 101 */
/* 102 */         if (comp > 0) {
/* 103 */           smj_rightRow = null;
/* 104 */         } else if (comp < 0) {
/* 105 */           if (!smj_matches.isEmpty()) {
/* 106 */             smj_value3 = smj_value.clone();
/* 107 */             return true;
/* 108 */           }
/* 109 */           smj_leftRow = null;
/* 110 */         } else {
/* 111 */           smj_matches.add(smj_rightRow.copy());
/* 112 */           smj_rightRow = null;;
/* 113 */         }
/* 114 */       } while (smj_leftRow != null);
/* 115 */     }
/* 116 */     return false; // unreachable
/* 117 */   }
/* 118 */
/* 119 */   protected void processNext() throws java.io.IOException {
/* 120 */     while (findNextInnerJoinRows(smj_leftInput, smj_rightInput)) {
/* 121 */       int smj_size = smj_matches.size();
/* 122 */       smj_isNull2 = smj_leftRow.isNullAt(0);
/* 123 */       smj_value4 = smj_isNull2 ? null : (smj_leftRow.getUTF8String(0));
/* 124 */       smj_isNull3 = smj_leftRow.isNullAt(1);
/* 125 */       smj_value5 = smj_isNull3 ? -1L : (smj_leftRow.getLong(1));
/* 126 */       smj_isNull4 = smj_leftRow.isNullAt(2);
/* 127 */       smj_value6 = smj_isNull4 ? -1L : (smj_leftRow.getLong(2));
/* 128 */       for (int smj_i = 0; smj_i < smj_size; smj_i ++) {
/* 129 */         InternalRow smj_rightRow1 = (InternalRow) smj_matches.get(smj_i);
/* 130 */
/* 131 */         smj_numOutputRows.add(1);
/* 132 */
/* 133 */         boolean smj_isNull6 = smj_rightRow1.isNullAt(1);
/* 134 */         long smj_value8 = smj_isNull6 ? -1L : (smj_rightRow1.getLong(1));
/* 135 */
/* 136 */         boolean project_isNull2 = true;
/* 137 */         double project_value2 = -1.0;
/* 138 */
/* 139 */         boolean project_isNull3 = false;
/* 140 */         double project_value3 = -1.0;
/* 141 */         if (false || 3.0D == 0) {
/* 142 */           project_isNull3 = true;
/* 143 */         } else {
/* 144 */           boolean project_isNull8 = true;
/* 145 */           long project_value8 = -1L;
/* 146 */
/* 147 */           boolean project_isNull9 = true;
/* 148 */           long project_value9 = -1L;
/* 149 */
/* 150 */           if (!smj_isNull3) {
/* 151 */             if (!smj_isNull4) {
/* 152 */               project_isNull9 = false; // resultCode could change nullability.
/* 153 */               project_value9 = smj_value5 + smj_value6;
/* 154 */
/* 155 */             }
/* 156 */
/* 157 */           }
/* 158 */           if (!project_isNull9) {
/* 159 */             if (!smj_isNull6) {
/* 160 */               project_isNull8 = false; // resultCode could change nullability.
/* 161 */               project_value8 = project_value9 + smj_value8;
/* 162 */
/* 163 */             }
/* 164 */
/* 165 */           }
/* 166 */           boolean project_isNull7 = project_isNull8;
/* 167 */           double project_value7 = -1.0;
/* 168 */           if (!project_isNull8) {
/* 169 */             project_value7 = (double) project_value8;
/* 170 */           }
/* 171 */           boolean project_isNull4 = false;
/* 172 */           double project_value4 = -1.0;
/* 173 */           if (project_isNull7 || project_value7 == 0) {
/* 174 */             project_isNull4 = true;
/* 175 */           } else {
/* 176 */             boolean project_isNull5 = smj_isNull3;
/* 177 */             double project_value5 = -1.0;
/* 178 */             if (!smj_isNull3) {
/* 179 */               project_value5 = (double) smj_value5;
/* 180 */             }
/* 181 */             if (project_isNull5) {
/* 182 */               project_isNull4 = true;
/* 183 */             } else {
/* 184 */               project_value4 = (double)(project_value5 / project_value7);
/* 185 */             }
/* 186 */           }
/* 187 */           if (project_isNull4) {
/* 188 */             project_isNull3 = true;
/* 189 */           } else {
/* 190 */             project_value3 = (double)(project_value4 / 3.0D);
/* 191 */           }
/* 192 */         }
/* 193 */         if (!project_isNull3) {
/* 194 */           project_isNull2 = false; // resultCode could change nullability.
/* 195 */           project_value2 = project_value3 * 100.0D;
/* 196 */
/* 197 */         }
/* 198 */         boolean project_isNull16 = true;
/* 199 */         double project_value16 = -1.0;
/* 200 */
/* 201 */         boolean project_isNull17 = false;
/* 202 */         double project_value17 = -1.0;
/* 203 */         if (false || 3.0D == 0) {
/* 204 */           project_isNull17 = true;
/* 205 */         } else {
/* 206 */           boolean project_isNull22 = true;
/* 207 */           long project_value22 = -1L;
/* 208 */
/* 209 */           boolean project_isNull23 = true;
/* 210 */           long project_value23 = -1L;
/* 211 */
/* 212 */           if (!smj_isNull3) {
/* 213 */             if (!smj_isNull4) {
/* 214 */               project_isNull23 = false; // resultCode could change nullability.
/* 215 */               project_value23 = smj_value5 + smj_value6;
/* 216 */
/* 217 */             }
/* 218 */
/* 219 */           }
/* 220 */           if (!project_isNull23) {
/* 221 */             if (!smj_isNull6) {
/* 222 */               project_isNull22 = false; // resultCode could change nullability.
/* 223 */               project_value22 = project_value23 + smj_value8;
/* 224 */
/* 225 */             }
/* 226 */
/* 227 */           }
/* 228 */           boolean project_isNull21 = project_isNull22;
/* 229 */           double project_value21 = -1.0;
/* 230 */           if (!project_isNull22) {
/* 231 */             project_value21 = (double) project_value22;
/* 232 */           }
/* 233 */           boolean project_isNull18 = false;
/* 234 */           double project_value18 = -1.0;
/* 235 */           if (project_isNull21 || project_value21 == 0) {
/* 236 */             project_isNull18 = true;
/* 237 */           } else {
/* 238 */             boolean project_isNull19 = smj_isNull4;
/* 239 */             double project_value19 = -1.0;
/* 240 */             if (!smj_isNull4) {
/* 241 */               project_value19 = (double) smj_value6;
/* 242 */             }
/* 243 */             if (project_isNull19) {
/* 244 */               project_isNull18 = true;
/* 245 */             } else {
/* 246 */               project_value18 = (double)(project_value19 / project_value21);
/* 247 */             }
/* 248 */           }
/* 249 */           if (project_isNull18) {
/* 250 */             project_isNull17 = true;
/* 251 */           } else {
/* 252 */             project_value17 = (double)(project_value18 / 3.0D);
/* 253 */           }
/* 254 */         }
/* 255 */         if (!project_isNull17) {
/* 256 */           project_isNull16 = false; // resultCode could change nullability.
/* 257 */           project_value16 = project_value17 * 100.0D;
/* 258 */
/* 259 */         }
/* 260 */         boolean project_isNull30 = true;
/* 261 */         double project_value30 = -1.0;
/* 262 */
/* 263 */         boolean project_isNull31 = false;
/* 264 */         double project_value31 = -1.0;
/* 265 */         if (false || 3.0D == 0) {
/* 266 */           project_isNull31 = true;
/* 267 */         } else {
/* 268 */           boolean project_isNull36 = true;
/* 269 */           long project_value36 = -1L;
/* 270 */
/* 271 */           boolean project_isNull37 = true;
/* 272 */           long project_value37 = -1L;
/* 273 */
/* 274 */           if (!smj_isNull3) {
/* 275 */             if (!smj_isNull4) {
/* 276 */               project_isNull37 = false; // resultCode could change nullability.
/* 277 */               project_value37 = smj_value5 + smj_value6;
/* 278 */
/* 279 */             }
/* 280 */
/* 281 */           }
/* 282 */           if (!project_isNull37) {
/* 283 */             if (!smj_isNull6) {
/* 284 */               project_isNull36 = false; // resultCode could change nullability.
/* 285 */               project_value36 = project_value37 + smj_value8;
/* 286 */
/* 287 */             }
/* 288 */
/* 289 */           }
/* 290 */           boolean project_isNull35 = project_isNull36;
/* 291 */           double project_value35 = -1.0;
/* 292 */           if (!project_isNull36) {
/* 293 */             project_value35 = (double) project_value36;
/* 294 */           }
/* 295 */           boolean project_isNull32 = false;
/* 296 */           double project_value32 = -1.0;
/* 297 */           if (project_isNull35 || project_value35 == 0) {
/* 298 */             project_isNull32 = true;
/* 299 */           } else {
/* 300 */             boolean project_isNull33 = smj_isNull6;
/* 301 */             double project_value33 = -1.0;
/* 302 */             if (!smj_isNull6) {
/* 303 */               project_value33 = (double) smj_value8;
/* 304 */             }
/* 305 */             if (project_isNull33) {
/* 306 */               project_isNull32 = true;
/* 307 */             } else {
/* 308 */               project_value32 = (double)(project_value33 / project_value35);
/* 309 */             }
/* 310 */           }
/* 311 */           if (project_isNull32) {
/* 312 */             project_isNull31 = true;
/* 313 */           } else {
/* 314 */             project_value31 = (double)(project_value32 / 3.0D);
/* 315 */           }
/* 316 */         }
/* 317 */         if (!project_isNull31) {
/* 318 */           project_isNull30 = false; // resultCode could change nullability.
/* 319 */           project_value30 = project_value31 * 100.0D;
/* 320 */
/* 321 */         }
/* 322 */         Object project_obj = ((Expression) references[1]).eval(null);
/* 323 */         Decimal project_value52 = (Decimal) project_obj;
/* 324 */         boolean project_isNull44 = false;
/* 325 */         Decimal project_value44 = null;
/* 326 */         if (false || project_value52.isZero()) {
/* 327 */           project_isNull44 = true;
/* 328 */         } else {
/* 329 */           boolean project_isNull47 = true;
/* 330 */           long project_value47 = -1L;
/* 331 */
/* 332 */           boolean project_isNull48 = true;
/* 333 */           long project_value48 = -1L;
/* 334 */
/* 335 */           if (!smj_isNull3) {
/* 336 */             if (!smj_isNull4) {
/* 337 */               project_isNull48 = false; // resultCode could change nullability.
/* 338 */               project_value48 = smj_value5 + smj_value6;
/* 339 */
/* 340 */             }
/* 341 */
/* 342 */           }
/* 343 */           if (!project_isNull48) {
/* 344 */             if (!smj_isNull6) {
/* 345 */               project_isNull47 = false; // resultCode could change nullability.
/* 346 */               project_value47 = project_value48 + smj_value8;
/* 347 */
/* 348 */             }
/* 349 */
/* 350 */           }
/* 351 */           boolean project_isNull46 = project_isNull47;
/* 352 */           Decimal project_value46 = null;
/* 353 */           if (!project_isNull47) {
/* 354 */             Decimal project_tmpDecimal = Decimal.apply((long) project_value47);
/* 355 */
/* 356 */             if (project_tmpDecimal.changePrecision(20, 0)) {
/* 357 */               project_value46 = project_tmpDecimal;
/* 358 */             } else {
/* 359 */               project_isNull46 = true;
/* 360 */             }
/* 361 */
/* 362 */           }
/* 363 */           boolean project_isNull45 = project_isNull46;
/* 364 */           Decimal project_value45 = null;
/* 365 */           if (!project_isNull46) {
/* 366 */             Decimal project_tmpDecimal1 = project_value46.clone();
/* 367 */
/* 368 */             if (project_tmpDecimal1.changePrecision(21, 1)) {
/* 369 */               project_value45 = project_tmpDecimal1;
/* 370 */             } else {
/* 371 */               project_isNull45 = true;
/* 372 */             }
/* 373 */
/* 374 */           }
/* 375 */           if (project_isNull45) {
/* 376 */             project_isNull44 = true;
/* 377 */           } else {
/* 378 */             project_value44 = project_value45.$div(project_value52);
/* 379 */           }
/* 380 */         }
/* 381 */         boolean project_isNull43 = project_isNull44;
/* 382 */         Decimal project_value43 = null;
/* 383 */
/* 384 */         if (!project_isNull44) {
/* 385 */           Decimal project_tmp = project_value44.clone();
/* 386 */           if (project_tmp.changePrecision(27, 6)) {
/* 387 */             project_value43 = project_tmp;
/* 388 */           } else {
/* 389 */             project_isNull43 = true;
/* 390 */           }
/* 391 */
/* 392 */         }
/* 393 */         project_holder.reset();
/* 394 */
/* 395 */         project_rowWriter.zeroOutNullBytes();
/* 396 */
/* 397 */         if (smj_isNull2) {
/* 398 */           project_rowWriter.setNullAt(0);
/* 399 */         } else {
/* 400 */           project_rowWriter.write(0, smj_value4);
/* 401 */         }
/* 402 */
/* 403 */         if (smj_isNull3) {
/* 404 */           project_rowWriter.setNullAt(1);
/* 405 */         } else {
/* 406 */           project_rowWriter.write(1, smj_value5);
/* 407 */         }
/* 408 */
/* 409 */         if (project_isNull2) {
/* 410 */           project_rowWriter.setNullAt(2);
/* 411 */         } else {
/* 412 */           project_rowWriter.write(2, project_value2);
/* 413 */         }
/* 414 */
/* 415 */         if (smj_isNull4) {
/* 416 */           project_rowWriter.setNullAt(3);
/* 417 */         } else {
/* 418 */           project_rowWriter.write(3, smj_value6);
/* 419 */         }
/* 420 */
/* 421 */         if (project_isNull16) {
/* 422 */           project_rowWriter.setNullAt(4);
/* 423 */         } else {
/* 424 */           project_rowWriter.write(4, project_value16);
/* 425 */         }
/* 426 */
/* 427 */         if (smj_isNull6) {
/* 428 */           project_rowWriter.setNullAt(5);
/* 429 */         } else {
/* 430 */           project_rowWriter.write(5, smj_value8);
/* 431 */         }
/* 432 */
/* 433 */         if (project_isNull30) {
/* 434 */           project_rowWriter.setNullAt(6);
/* 435 */         } else {
/* 436 */           project_rowWriter.write(6, project_value30);
/* 437 */         }
/* 438 */
/* 439 */         if (project_isNull43) {
/* 440 */           project_rowWriter.write(7, (Decimal) null, 27, 6);
/* 441 */         } else {
/* 442 */           project_rowWriter.write(7, project_value43, 27, 6);
/* 443 */         }
/* 444 */         project_result.setTotalSize(project_holder.totalSize());
/* 445 */         append(project_result.copy());
/* 446 */
/* 447 */       }
/* 448 */       if (shouldStop()) return;
/* 449 */     }
/* 450 */   }
/* 451 */ }
