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
/* 012 */   private int smj_value4;
/* 013 */   private org.apache.spark.sql.execution.ExternalAppendOnlyUnsafeRowArray smj_matches;
/* 014 */   private int smj_value5;
/* 015 */   private int smj_value6;
/* 016 */   private boolean smj_isNull4;
/* 017 */   private double smj_value7;
/* 018 */   private boolean smj_isNull5;
/* 019 */   private double smj_value8;
/* 020 */   private boolean smj_isNull6;
/* 021 */   private double smj_value9;
/* 022 */   private boolean smj_isNull7;
/* 023 */   private double smj_value10;
/* 024 */   private boolean smj_isNull8;
/* 025 */   private double smj_value11;
/* 026 */   private boolean smj_isNull9;
/* 027 */   private double smj_value12;
/* 028 */   private boolean smj_isNull10;
/* 029 */   private double smj_value13;
/* 030 */   private boolean smj_isNull11;
/* 031 */   private org.apache.spark.sql.execution.metric.SQLMetric smj_numOutputRows;
/* 032 */   private UnsafeRow smj_result;
/* 033 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder smj_holder;
/* 034 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter smj_rowWriter;
/* 035 */   private UnsafeRow project_result;
/* 036 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 037 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 038 */
/* 039 */   public GeneratedIterator(Object[] references) {
/* 040 */     this.references = references;
/* 041 */   }
/* 042 */
/* 043 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 044 */     partitionIndex = index;
/* 045 */     this.inputs = inputs;
/* 046 */     smj_leftInput = inputs[0];
/* 047 */     smj_rightInput = inputs[1];
/* 048 */
/* 049 */     smj_rightRow = null;
/* 050 */
/* 051 */     smj_matches = new org.apache.spark.sql.execution.ExternalAppendOnlyUnsafeRowArray(2147483647);
/* 052 */
/* 053 */     this.smj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[0];
/* 054 */     smj_result = new UnsafeRow(16);
/* 055 */     this.smj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(smj_result, 0);
/* 056 */     this.smj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(smj_holder, 16);
/* 057 */     project_result = new UnsafeRow(8);
/* 058 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 0);
/* 059 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 8);
/* 060 */
/* 061 */   }
/* 062 */
/* 063 */   private boolean findNextInnerJoinRows(
/* 064 */     scala.collection.Iterator leftIter,
/* 065 */     scala.collection.Iterator rightIter) {
/* 066 */     smj_leftRow = null;
/* 067 */     int comp = 0;
/* 068 */     while (smj_leftRow == null) {
/* 069 */       if (!leftIter.hasNext()) return false;
/* 070 */       smj_leftRow = (InternalRow) leftIter.next();
/* 071 */
/* 072 */       boolean smj_isNull = smj_leftRow.isNullAt(0);
/* 073 */       int smj_value = smj_isNull ? -1 : (smj_leftRow.getInt(0));
/* 074 */       if (smj_isNull) {
/* 075 */         smj_leftRow = null;
/* 076 */         continue;
/* 077 */       }
/* 078 */       if (!smj_matches.isEmpty()) {
/* 079 */         comp = 0;
/* 080 */         if (comp == 0) {
/* 081 */           comp = (smj_value > smj_value5 ? 1 : smj_value < smj_value5 ? -1 : 0);
/* 082 */         }
/* 083 */
/* 084 */         if (comp == 0) {
/* 085 */           return true;
/* 086 */         }
/* 087 */         smj_matches.clear();
/* 088 */       }
/* 089 */
/* 090 */       do {
/* 091 */         if (smj_rightRow == null) {
/* 092 */           if (!rightIter.hasNext()) {
/* 093 */             smj_value5 = smj_value;
/* 094 */             return !smj_matches.isEmpty();
/* 095 */           }
/* 096 */           smj_rightRow = (InternalRow) rightIter.next();
/* 097 */
/* 098 */           boolean smj_isNull1 = true;
/* 099 */           int smj_value1 = -1;
/* 100 */
/* 101 */           boolean smj_isNull2 = smj_rightRow.isNullAt(0);
/* 102 */           int smj_value2 = smj_isNull2 ? -1 : (smj_rightRow.getInt(0));
/* 103 */           if (!smj_isNull2) {
/* 104 */             smj_isNull1 = false; // resultCode could change nullability.
/* 105 */             smj_value1 = smj_value2 - 53;
/* 106 */
/* 107 */           }
/* 108 */           if (smj_isNull1) {
/* 109 */             smj_rightRow = null;
/* 110 */             continue;
/* 111 */           }
/* 112 */           smj_value4 = smj_value1;
/* 113 */         }
/* 114 */
/* 115 */         comp = 0;
/* 116 */         if (comp == 0) {
/* 117 */           comp = (smj_value > smj_value4 ? 1 : smj_value < smj_value4 ? -1 : 0);
/* 118 */         }
/* 119 */
/* 120 */         if (comp > 0) {
/* 121 */           smj_rightRow = null;
/* 122 */         } else if (comp < 0) {
/* 123 */           if (!smj_matches.isEmpty()) {
/* 124 */             smj_value5 = smj_value;
/* 125 */             return true;
/* 126 */           }
/* 127 */           smj_leftRow = null;
/* 128 */         } else {
/* 129 */           smj_matches.add((UnsafeRow) smj_rightRow);
/* 130 */           smj_rightRow = null;;
/* 131 */         }
/* 132 */       } while (smj_leftRow != null);
/* 133 */     }
/* 134 */     return false; // unreachable
/* 135 */   }
/* 136 */
/* 137 */   protected void processNext() throws java.io.IOException {
/* 138 */     while (findNextInnerJoinRows(smj_leftInput, smj_rightInput)) {
/* 139 */       smj_isNull4 = smj_leftRow.isNullAt(0);
/* 140 */       smj_value6 = smj_isNull4 ? -1 : (smj_leftRow.getInt(0));
/* 141 */       smj_isNull5 = smj_leftRow.isNullAt(1);
/* 142 */       smj_value7 = smj_isNull5 ? -1.0 : (smj_leftRow.getDouble(1));
/* 143 */       smj_isNull6 = smj_leftRow.isNullAt(2);
/* 144 */       smj_value8 = smj_isNull6 ? -1.0 : (smj_leftRow.getDouble(2));
/* 145 */       smj_isNull7 = smj_leftRow.isNullAt(3);
/* 146 */       smj_value9 = smj_isNull7 ? -1.0 : (smj_leftRow.getDouble(3));
/* 147 */       smj_isNull8 = smj_leftRow.isNullAt(4);
/* 148 */       smj_value10 = smj_isNull8 ? -1.0 : (smj_leftRow.getDouble(4));
/* 149 */       smj_isNull9 = smj_leftRow.isNullAt(5);
/* 150 */       smj_value11 = smj_isNull9 ? -1.0 : (smj_leftRow.getDouble(5));
/* 151 */       smj_isNull10 = smj_leftRow.isNullAt(6);
/* 152 */       smj_value12 = smj_isNull10 ? -1.0 : (smj_leftRow.getDouble(6));
/* 153 */       smj_isNull11 = smj_leftRow.isNullAt(7);
/* 154 */       smj_value13 = smj_isNull11 ? -1.0 : (smj_leftRow.getDouble(7));
/* 155 */       scala.collection.Iterator<UnsafeRow> smj_iterator = smj_matches.generateIterator();
/* 156 */       while (smj_iterator.hasNext()) {
/* 157 */         InternalRow smj_rightRow1 = (InternalRow) smj_iterator.next();
/* 158 */
/* 159 */         smj_numOutputRows.add(1);
/* 160 */
/* 161 */         boolean smj_isNull13 = smj_rightRow1.isNullAt(1);
/* 162 */         double smj_value15 = smj_isNull13 ? -1.0 : (smj_rightRow1.getDouble(1));
/* 163 */         boolean project_isNull2 = false;
/* 164 */         double project_value2 = -1.0;
/* 165 */         if (smj_isNull13 || smj_value15 == 0) {
/* 166 */           project_isNull2 = true;
/* 167 */         } else {
/* 168 */           if (smj_isNull5) {
/* 169 */             project_isNull2 = true;
/* 170 */           } else {
/* 171 */             project_value2 = (double)(smj_value7 / smj_value15);
/* 172 */           }
/* 173 */         }
/* 174 */         boolean project_isNull1 = project_isNull2;
/* 175 */         double project_value1 = -1.0;
/* 176 */         if (!project_isNull1) {
/* 177 */           if (Double.isNaN(project_value2) || Double.isInfinite(project_value2)) {
/* 178 */             project_value1 = project_value2;
/* 179 */           } else {
/* 180 */             project_value1 = java.math.BigDecimal.valueOf(project_value2).
/* 181 */             setScale(2, java.math.BigDecimal.ROUND_HALF_UP).doubleValue();
/* 182 */           }
/* 183 */         }
/* 184 */         boolean smj_isNull14 = smj_rightRow1.isNullAt(2);
/* 185 */         double smj_value16 = smj_isNull14 ? -1.0 : (smj_rightRow1.getDouble(2));
/* 186 */         boolean project_isNull6 = false;
/* 187 */         double project_value6 = -1.0;
/* 188 */         if (smj_isNull14 || smj_value16 == 0) {
/* 189 */           project_isNull6 = true;
/* 190 */         } else {
/* 191 */           if (smj_isNull6) {
/* 192 */             project_isNull6 = true;
/* 193 */           } else {
/* 194 */             project_value6 = (double)(smj_value8 / smj_value16);
/* 195 */           }
/* 196 */         }
/* 197 */         boolean project_isNull5 = project_isNull6;
/* 198 */         double project_value5 = -1.0;
/* 199 */         if (!project_isNull5) {
/* 200 */           if (Double.isNaN(project_value6) || Double.isInfinite(project_value6)) {
/* 201 */             project_value5 = project_value6;
/* 202 */           } else {
/* 203 */             project_value5 = java.math.BigDecimal.valueOf(project_value6).
/* 204 */             setScale(2, java.math.BigDecimal.ROUND_HALF_UP).doubleValue();
/* 205 */           }
/* 206 */         }
/* 207 */         boolean smj_isNull15 = smj_rightRow1.isNullAt(3);
/* 208 */         double smj_value17 = smj_isNull15 ? -1.0 : (smj_rightRow1.getDouble(3));
/* 209 */         boolean project_isNull10 = false;
/* 210 */         double project_value10 = -1.0;
/* 211 */         if (smj_isNull15 || smj_value17 == 0) {
/* 212 */           project_isNull10 = true;
/* 213 */         } else {
/* 214 */           if (smj_isNull7) {
/* 215 */             project_isNull10 = true;
/* 216 */           } else {
/* 217 */             project_value10 = (double)(smj_value9 / smj_value17);
/* 218 */           }
/* 219 */         }
/* 220 */         boolean project_isNull9 = project_isNull10;
/* 221 */         double project_value9 = -1.0;
/* 222 */         if (!project_isNull9) {
/* 223 */           if (Double.isNaN(project_value10) || Double.isInfinite(project_value10)) {
/* 224 */             project_value9 = project_value10;
/* 225 */           } else {
/* 226 */             project_value9 = java.math.BigDecimal.valueOf(project_value10).
/* 227 */             setScale(2, java.math.BigDecimal.ROUND_HALF_UP).doubleValue();
/* 228 */           }
/* 229 */         }
/* 230 */         boolean smj_isNull16 = smj_rightRow1.isNullAt(4);
/* 231 */         double smj_value18 = smj_isNull16 ? -1.0 : (smj_rightRow1.getDouble(4));
/* 232 */         boolean project_isNull14 = false;
/* 233 */         double project_value14 = -1.0;
/* 234 */         if (smj_isNull16 || smj_value18 == 0) {
/* 235 */           project_isNull14 = true;
/* 236 */         } else {
/* 237 */           if (smj_isNull8) {
/* 238 */             project_isNull14 = true;
/* 239 */           } else {
/* 240 */             project_value14 = (double)(smj_value10 / smj_value18);
/* 241 */           }
/* 242 */         }
/* 243 */         boolean project_isNull13 = project_isNull14;
/* 244 */         double project_value13 = -1.0;
/* 245 */         if (!project_isNull13) {
/* 246 */           if (Double.isNaN(project_value14) || Double.isInfinite(project_value14)) {
/* 247 */             project_value13 = project_value14;
/* 248 */           } else {
/* 249 */             project_value13 = java.math.BigDecimal.valueOf(project_value14).
/* 250 */             setScale(2, java.math.BigDecimal.ROUND_HALF_UP).doubleValue();
/* 251 */           }
/* 252 */         }
/* 253 */         boolean smj_isNull17 = smj_rightRow1.isNullAt(5);
/* 254 */         double smj_value19 = smj_isNull17 ? -1.0 : (smj_rightRow1.getDouble(5));
/* 255 */         boolean project_isNull18 = false;
/* 256 */         double project_value18 = -1.0;
/* 257 */         if (smj_isNull17 || smj_value19 == 0) {
/* 258 */           project_isNull18 = true;
/* 259 */         } else {
/* 260 */           if (smj_isNull9) {
/* 261 */             project_isNull18 = true;
/* 262 */           } else {
/* 263 */             project_value18 = (double)(smj_value11 / smj_value19);
/* 264 */           }
/* 265 */         }
/* 266 */         boolean project_isNull17 = project_isNull18;
/* 267 */         double project_value17 = -1.0;
/* 268 */         if (!project_isNull17) {
/* 269 */           if (Double.isNaN(project_value18) || Double.isInfinite(project_value18)) {
/* 270 */             project_value17 = project_value18;
/* 271 */           } else {
/* 272 */             project_value17 = java.math.BigDecimal.valueOf(project_value18).
/* 273 */             setScale(2, java.math.BigDecimal.ROUND_HALF_UP).doubleValue();
/* 274 */           }
/* 275 */         }
/* 276 */         boolean smj_isNull18 = smj_rightRow1.isNullAt(6);
/* 277 */         double smj_value20 = smj_isNull18 ? -1.0 : (smj_rightRow1.getDouble(6));
/* 278 */         boolean project_isNull22 = false;
/* 279 */         double project_value22 = -1.0;
/* 280 */         if (smj_isNull18 || smj_value20 == 0) {
/* 281 */           project_isNull22 = true;
/* 282 */         } else {
/* 283 */           if (smj_isNull10) {
/* 284 */             project_isNull22 = true;
/* 285 */           } else {
/* 286 */             project_value22 = (double)(smj_value12 / smj_value20);
/* 287 */           }
/* 288 */         }
/* 289 */         boolean project_isNull21 = project_isNull22;
/* 290 */         double project_value21 = -1.0;
/* 291 */         if (!project_isNull21) {
/* 292 */           if (Double.isNaN(project_value22) || Double.isInfinite(project_value22)) {
/* 293 */             project_value21 = project_value22;
/* 294 */           } else {
/* 295 */             project_value21 = java.math.BigDecimal.valueOf(project_value22).
/* 296 */             setScale(2, java.math.BigDecimal.ROUND_HALF_UP).doubleValue();
/* 297 */           }
/* 298 */         }
/* 299 */         boolean smj_isNull19 = smj_rightRow1.isNullAt(7);
/* 300 */         double smj_value21 = smj_isNull19 ? -1.0 : (smj_rightRow1.getDouble(7));
/* 301 */         boolean project_isNull26 = false;
/* 302 */         double project_value26 = -1.0;
/* 303 */         if (smj_isNull19 || smj_value21 == 0) {
/* 304 */           project_isNull26 = true;
/* 305 */         } else {
/* 306 */           if (smj_isNull11) {
/* 307 */             project_isNull26 = true;
/* 308 */           } else {
/* 309 */             project_value26 = (double)(smj_value13 / smj_value21);
/* 310 */           }
/* 311 */         }
/* 312 */         boolean project_isNull25 = project_isNull26;
/* 313 */         double project_value25 = -1.0;
/* 314 */         if (!project_isNull25) {
/* 315 */           if (Double.isNaN(project_value26) || Double.isInfinite(project_value26)) {
/* 316 */             project_value25 = project_value26;
/* 317 */           } else {
/* 318 */             project_value25 = java.math.BigDecimal.valueOf(project_value26).
/* 319 */             setScale(2, java.math.BigDecimal.ROUND_HALF_UP).doubleValue();
/* 320 */           }
/* 321 */         }
/* 322 */         project_rowWriter.zeroOutNullBytes();
/* 323 */
/* 324 */         if (smj_isNull4) {
/* 325 */           project_rowWriter.setNullAt(0);
/* 326 */         } else {
/* 327 */           project_rowWriter.write(0, smj_value6);
/* 328 */         }
/* 329 */
/* 330 */         if (project_isNull1) {
/* 331 */           project_rowWriter.setNullAt(1);
/* 332 */         } else {
/* 333 */           project_rowWriter.write(1, project_value1);
/* 334 */         }
/* 335 */
/* 336 */         if (project_isNull5) {
/* 337 */           project_rowWriter.setNullAt(2);
/* 338 */         } else {
/* 339 */           project_rowWriter.write(2, project_value5);
/* 340 */         }
/* 341 */
/* 342 */         if (project_isNull9) {
/* 343 */           project_rowWriter.setNullAt(3);
/* 344 */         } else {
/* 345 */           project_rowWriter.write(3, project_value9);
/* 346 */         }
/* 347 */
/* 348 */         if (project_isNull13) {
/* 349 */           project_rowWriter.setNullAt(4);
/* 350 */         } else {
/* 351 */           project_rowWriter.write(4, project_value13);
/* 352 */         }
/* 353 */
/* 354 */         if (project_isNull17) {
/* 355 */           project_rowWriter.setNullAt(5);
/* 356 */         } else {
/* 357 */           project_rowWriter.write(5, project_value17);
/* 358 */         }
/* 359 */
/* 360 */         if (project_isNull21) {
/* 361 */           project_rowWriter.setNullAt(6);
/* 362 */         } else {
/* 363 */           project_rowWriter.write(6, project_value21);
/* 364 */         }
/* 365 */
/* 366 */         if (project_isNull25) {
/* 367 */           project_rowWriter.setNullAt(7);
/* 368 */         } else {
/* 369 */           project_rowWriter.write(7, project_value25);
/* 370 */         }
/* 371 */         append(project_result.copy());
/* 372 */
/* 373 */       }
/* 374 */       if (shouldStop()) return;
/* 375 */     }
/* 376 */   }
/* 377 */ }
