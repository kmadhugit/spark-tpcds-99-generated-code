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
/* 012 */   private int smj_value6;
/* 013 */   private int smj_value7;
/* 014 */   private int smj_value8;
/* 015 */   private org.apache.spark.sql.execution.ExternalAppendOnlyUnsafeRowArray smj_matches;
/* 016 */   private int smj_value9;
/* 017 */   private int smj_value10;
/* 018 */   private int smj_value11;
/* 019 */   private int smj_value12;
/* 020 */   private boolean smj_isNull6;
/* 021 */   private int smj_value13;
/* 022 */   private boolean smj_isNull7;
/* 023 */   private int smj_value14;
/* 024 */   private boolean smj_isNull8;
/* 025 */   private long smj_value15;
/* 026 */   private boolean smj_isNull9;
/* 027 */   private double smj_value16;
/* 028 */   private boolean smj_isNull10;
/* 029 */   private double smj_value17;
/* 030 */   private boolean smj_isNull11;
/* 031 */   private long smj_value18;
/* 032 */   private boolean smj_isNull12;
/* 033 */   private double smj_value19;
/* 034 */   private boolean smj_isNull13;
/* 035 */   private double smj_value20;
/* 036 */   private boolean smj_isNull14;
/* 037 */   private org.apache.spark.sql.execution.metric.SQLMetric smj_numOutputRows;
/* 038 */   private UnsafeRow smj_result;
/* 039 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder smj_holder;
/* 040 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter smj_rowWriter;
/* 041 */   private UnsafeRow project_result;
/* 042 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 043 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 044 */
/* 045 */   public GeneratedIterator(Object[] references) {
/* 046 */     this.references = references;
/* 047 */   }
/* 048 */
/* 049 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 050 */     partitionIndex = index;
/* 051 */     this.inputs = inputs;
/* 052 */     smj_leftInput = inputs[0];
/* 053 */     smj_rightInput = inputs[1];
/* 054 */
/* 055 */     smj_rightRow = null;
/* 056 */
/* 057 */     smj_matches = new org.apache.spark.sql.execution.ExternalAppendOnlyUnsafeRowArray(2147483647);
/* 058 */
/* 059 */     this.smj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[0];
/* 060 */     smj_result = new UnsafeRow(15);
/* 061 */     this.smj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(smj_result, 0);
/* 062 */     this.smj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(smj_holder, 15);
/* 063 */     project_result = new UnsafeRow(12);
/* 064 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 0);
/* 065 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 12);
/* 066 */
/* 067 */   }
/* 068 */
/* 069 */   private boolean findNextInnerJoinRows(
/* 070 */     scala.collection.Iterator leftIter,
/* 071 */     scala.collection.Iterator rightIter) {
/* 072 */     smj_leftRow = null;
/* 073 */     int comp = 0;
/* 074 */     while (smj_leftRow == null) {
/* 075 */       if (!leftIter.hasNext()) return false;
/* 076 */       smj_leftRow = (InternalRow) leftIter.next();
/* 077 */
/* 078 */       boolean smj_isNull = smj_leftRow.isNullAt(0);
/* 079 */       int smj_value = smj_isNull ? -1 : (smj_leftRow.getInt(0));
/* 080 */
/* 081 */       boolean smj_isNull1 = smj_leftRow.isNullAt(1);
/* 082 */       int smj_value1 = smj_isNull1 ? -1 : (smj_leftRow.getInt(1));
/* 083 */
/* 084 */       boolean smj_isNull2 = smj_leftRow.isNullAt(2);
/* 085 */       int smj_value2 = smj_isNull2 ? -1 : (smj_leftRow.getInt(2));
/* 086 */       if (smj_isNull || smj_isNull1 || smj_isNull2) {
/* 087 */         smj_leftRow = null;
/* 088 */         continue;
/* 089 */       }
/* 090 */       if (!smj_matches.isEmpty()) {
/* 091 */         comp = 0;
/* 092 */         if (comp == 0) {
/* 093 */           comp = (smj_value > smj_value9 ? 1 : smj_value < smj_value9 ? -1 : 0);
/* 094 */         }
/* 095 */         if (comp == 0) {
/* 096 */           comp = (smj_value1 > smj_value10 ? 1 : smj_value1 < smj_value10 ? -1 : 0);
/* 097 */         }
/* 098 */         if (comp == 0) {
/* 099 */           comp = (smj_value2 > smj_value11 ? 1 : smj_value2 < smj_value11 ? -1 : 0);
/* 100 */         }
/* 101 */
/* 102 */         if (comp == 0) {
/* 103 */           return true;
/* 104 */         }
/* 105 */         smj_matches.clear();
/* 106 */       }
/* 107 */
/* 108 */       do {
/* 109 */         if (smj_rightRow == null) {
/* 110 */           if (!rightIter.hasNext()) {
/* 111 */             smj_value9 = smj_value;
/* 112 */             smj_value10 = smj_value1;
/* 113 */             smj_value11 = smj_value2;
/* 114 */             return !smj_matches.isEmpty();
/* 115 */           }
/* 116 */           smj_rightRow = (InternalRow) rightIter.next();
/* 117 */
/* 118 */           boolean smj_isNull3 = smj_rightRow.isNullAt(0);
/* 119 */           int smj_value3 = smj_isNull3 ? -1 : (smj_rightRow.getInt(0));
/* 120 */
/* 121 */           boolean smj_isNull4 = smj_rightRow.isNullAt(1);
/* 122 */           int smj_value4 = smj_isNull4 ? -1 : (smj_rightRow.getInt(1));
/* 123 */
/* 124 */           boolean smj_isNull5 = smj_rightRow.isNullAt(2);
/* 125 */           int smj_value5 = smj_isNull5 ? -1 : (smj_rightRow.getInt(2));
/* 126 */           if (smj_isNull3 || smj_isNull4 || smj_isNull5) {
/* 127 */             smj_rightRow = null;
/* 128 */             continue;
/* 129 */           }
/* 130 */           smj_value6 = smj_value3;
/* 131 */           smj_value7 = smj_value4;
/* 132 */           smj_value8 = smj_value5;
/* 133 */         }
/* 134 */
/* 135 */         comp = 0;
/* 136 */         if (comp == 0) {
/* 137 */           comp = (smj_value > smj_value6 ? 1 : smj_value < smj_value6 ? -1 : 0);
/* 138 */         }
/* 139 */         if (comp == 0) {
/* 140 */           comp = (smj_value1 > smj_value7 ? 1 : smj_value1 < smj_value7 ? -1 : 0);
/* 141 */         }
/* 142 */         if (comp == 0) {
/* 143 */           comp = (smj_value2 > smj_value8 ? 1 : smj_value2 < smj_value8 ? -1 : 0);
/* 144 */         }
/* 145 */
/* 146 */         if (comp > 0) {
/* 147 */           smj_rightRow = null;
/* 148 */         } else if (comp < 0) {
/* 149 */           if (!smj_matches.isEmpty()) {
/* 150 */             smj_value9 = smj_value;
/* 151 */             smj_value10 = smj_value1;
/* 152 */             smj_value11 = smj_value2;
/* 153 */             return true;
/* 154 */           }
/* 155 */           smj_leftRow = null;
/* 156 */         } else {
/* 157 */           smj_matches.add((UnsafeRow) smj_rightRow);
/* 158 */           smj_rightRow = null;;
/* 159 */         }
/* 160 */       } while (smj_leftRow != null);
/* 161 */     }
/* 162 */     return false; // unreachable
/* 163 */   }
/* 164 */
/* 165 */   protected void processNext() throws java.io.IOException {
/* 166 */     while (findNextInnerJoinRows(smj_leftInput, smj_rightInput)) {
/* 167 */       smj_isNull6 = smj_leftRow.isNullAt(0);
/* 168 */       smj_value12 = smj_isNull6 ? -1 : (smj_leftRow.getInt(0));
/* 169 */       smj_isNull7 = smj_leftRow.isNullAt(1);
/* 170 */       smj_value13 = smj_isNull7 ? -1 : (smj_leftRow.getInt(1));
/* 171 */       smj_isNull8 = smj_leftRow.isNullAt(2);
/* 172 */       smj_value14 = smj_isNull8 ? -1 : (smj_leftRow.getInt(2));
/* 173 */       smj_isNull9 = smj_leftRow.isNullAt(3);
/* 174 */       smj_value15 = smj_isNull9 ? -1L : (smj_leftRow.getLong(3));
/* 175 */       smj_isNull10 = smj_leftRow.isNullAt(4);
/* 176 */       smj_value16 = smj_isNull10 ? -1.0 : (smj_leftRow.getDouble(4));
/* 177 */       smj_isNull11 = smj_leftRow.isNullAt(5);
/* 178 */       smj_value17 = smj_isNull11 ? -1.0 : (smj_leftRow.getDouble(5));
/* 179 */       smj_isNull12 = smj_leftRow.isNullAt(6);
/* 180 */       smj_value18 = smj_isNull12 ? -1L : (smj_leftRow.getLong(6));
/* 181 */       smj_isNull13 = smj_leftRow.isNullAt(7);
/* 182 */       smj_value19 = smj_isNull13 ? -1.0 : (smj_leftRow.getDouble(7));
/* 183 */       smj_isNull14 = smj_leftRow.isNullAt(8);
/* 184 */       smj_value20 = smj_isNull14 ? -1.0 : (smj_leftRow.getDouble(8));
/* 185 */       scala.collection.Iterator<UnsafeRow> smj_iterator = smj_matches.generateIterator();
/* 186 */       while (smj_iterator.hasNext()) {
/* 187 */         InternalRow smj_rightRow1 = (InternalRow) smj_iterator.next();
/* 188 */
/* 189 */         smj_numOutputRows.add(1);
/* 190 */
/* 191 */         boolean smj_isNull18 = smj_rightRow1.isNullAt(3);
/* 192 */         long smj_value24 = smj_isNull18 ? -1L : (smj_rightRow1.getLong(3));
/* 193 */
/* 194 */         boolean project_isNull6 = true;
/* 195 */         long project_value6 = -1L;
/* 196 */
/* 197 */         if (!smj_isNull12) {
/* 198 */           if (!smj_isNull18) {
/* 199 */             project_isNull6 = false; // resultCode could change nullability.
/* 200 */             project_value6 = smj_value18 + smj_value24;
/* 201 */
/* 202 */           }
/* 203 */
/* 204 */         }
/* 205 */         boolean project_isNull5 = project_isNull6;
/* 206 */         long project_value5 = project_value6;
/* 207 */         if (project_isNull5) {
/* 208 */           if (!false) {
/* 209 */             project_isNull5 = false;
/* 210 */             project_value5 = 1L;
/* 211 */           }
/* 212 */         }
/* 213 */         boolean project_isNull4 = project_isNull5;
/* 214 */         double project_value4 = -1.0;
/* 215 */         if (!project_isNull5) {
/* 216 */           project_value4 = (double) project_value5;
/* 217 */         }
/* 218 */         boolean project_isNull1 = false;
/* 219 */         double project_value1 = -1.0;
/* 220 */         if (project_isNull4 || project_value4 == 0) {
/* 221 */           project_isNull1 = true;
/* 222 */         } else {
/* 223 */           boolean project_isNull2 = smj_isNull9;
/* 224 */           double project_value2 = -1.0;
/* 225 */           if (!smj_isNull9) {
/* 226 */             project_value2 = (double) smj_value15;
/* 227 */           }
/* 228 */           if (project_isNull2) {
/* 229 */             project_isNull1 = true;
/* 230 */           } else {
/* 231 */             project_value1 = (double)(project_value2 / project_value4);
/* 232 */           }
/* 233 */         }
/* 234 */         boolean project_isNull = project_isNull1;
/* 235 */         double project_value = -1.0;
/* 236 */         if (!project_isNull) {
/* 237 */           if (Double.isNaN(project_value1) || Double.isInfinite(project_value1)) {
/* 238 */             project_value = project_value1;
/* 239 */           } else {
/* 240 */             project_value = java.math.BigDecimal.valueOf(project_value1).
/* 241 */             setScale(2, java.math.BigDecimal.ROUND_HALF_UP).doubleValue();
/* 242 */           }
/* 243 */         }
/* 244 */         boolean project_isNull13 = false;
/* 245 */
/* 246 */         boolean project_isNull14 = smj_isNull12;
/* 247 */         long project_value14 = smj_value18;
/* 248 */         if (project_isNull14) {
/* 249 */           if (!false) {
/* 250 */             project_isNull14 = false;
/* 251 */             project_value14 = 0L;
/* 252 */           }
/* 253 */         }
/* 254 */
/* 255 */         boolean project_isNull17 = smj_isNull18;
/* 256 */         long project_value17 = smj_value24;
/* 257 */         if (project_isNull17) {
/* 258 */           if (!false) {
/* 259 */             project_isNull17 = false;
/* 260 */             project_value17 = 0L;
/* 261 */           }
/* 262 */         }
/* 263 */         long project_value13 = -1L;
/* 264 */         project_value13 = project_value14 + project_value17;
/* 265 */         boolean project_isNull20 = false;
/* 266 */
/* 267 */         boolean project_isNull21 = smj_isNull13;
/* 268 */         double project_value21 = smj_value19;
/* 269 */         if (project_isNull21) {
/* 270 */           if (!false) {
/* 271 */             project_isNull21 = false;
/* 272 */             project_value21 = 0.0D;
/* 273 */           }
/* 274 */         }
/* 275 */
/* 276 */         boolean smj_isNull19 = smj_rightRow1.isNullAt(4);
/* 277 */         double smj_value25 = smj_isNull19 ? -1.0 : (smj_rightRow1.getDouble(4));
/* 278 */         boolean project_isNull24 = smj_isNull19;
/* 279 */         double project_value24 = smj_value25;
/* 280 */         if (project_isNull24) {
/* 281 */           if (!false) {
/* 282 */             project_isNull24 = false;
/* 283 */             project_value24 = 0.0D;
/* 284 */           }
/* 285 */         }
/* 286 */         double project_value20 = -1.0;
/* 287 */         project_value20 = project_value21 + project_value24;
/* 288 */         boolean project_isNull27 = false;
/* 289 */
/* 290 */         boolean project_isNull28 = smj_isNull14;
/* 291 */         double project_value28 = smj_value20;
/* 292 */         if (project_isNull28) {
/* 293 */           if (!false) {
/* 294 */             project_isNull28 = false;
/* 295 */             project_value28 = 0.0D;
/* 296 */           }
/* 297 */         }
/* 298 */
/* 299 */         boolean smj_isNull20 = smj_rightRow1.isNullAt(5);
/* 300 */         double smj_value26 = smj_isNull20 ? -1.0 : (smj_rightRow1.getDouble(5));
/* 301 */         boolean project_isNull31 = smj_isNull20;
/* 302 */         double project_value31 = smj_value26;
/* 303 */         if (project_isNull31) {
/* 304 */           if (!false) {
/* 305 */             project_isNull31 = false;
/* 306 */             project_value31 = 0.0D;
/* 307 */           }
/* 308 */         }
/* 309 */         double project_value27 = -1.0;
/* 310 */         project_value27 = project_value28 + project_value31;
/* 311 */         project_rowWriter.zeroOutNullBytes();
/* 312 */
/* 313 */         if (project_isNull) {
/* 314 */           project_rowWriter.setNullAt(0);
/* 315 */         } else {
/* 316 */           project_rowWriter.write(0, project_value);
/* 317 */         }
/* 318 */
/* 319 */         if (smj_isNull9) {
/* 320 */           project_rowWriter.setNullAt(1);
/* 321 */         } else {
/* 322 */           project_rowWriter.write(1, smj_value15);
/* 323 */         }
/* 324 */
/* 325 */         if (smj_isNull10) {
/* 326 */           project_rowWriter.setNullAt(2);
/* 327 */         } else {
/* 328 */           project_rowWriter.write(2, smj_value16);
/* 329 */         }
/* 330 */
/* 331 */         if (smj_isNull11) {
/* 332 */           project_rowWriter.setNullAt(3);
/* 333 */         } else {
/* 334 */           project_rowWriter.write(3, smj_value17);
/* 335 */         }
/* 336 */
/* 337 */         project_rowWriter.write(4, project_value13);
/* 338 */
/* 339 */         project_rowWriter.write(5, project_value20);
/* 340 */
/* 341 */         project_rowWriter.write(6, project_value27);
/* 342 */
/* 343 */         if (smj_isNull18) {
/* 344 */           project_rowWriter.setNullAt(7);
/* 345 */         } else {
/* 346 */           project_rowWriter.write(7, smj_value24);
/* 347 */         }
/* 348 */
/* 349 */         if (smj_isNull12) {
/* 350 */           project_rowWriter.setNullAt(8);
/* 351 */         } else {
/* 352 */           project_rowWriter.write(8, smj_value18);
/* 353 */         }
/* 354 */
/* 355 */         if (smj_isNull10) {
/* 356 */           project_rowWriter.setNullAt(9);
/* 357 */         } else {
/* 358 */           project_rowWriter.write(9, smj_value16);
/* 359 */         }
/* 360 */
/* 361 */         if (smj_isNull9) {
/* 362 */           project_rowWriter.setNullAt(10);
/* 363 */         } else {
/* 364 */           project_rowWriter.write(10, smj_value15);
/* 365 */         }
/* 366 */
/* 367 */         if (smj_isNull11) {
/* 368 */           project_rowWriter.setNullAt(11);
/* 369 */         } else {
/* 370 */           project_rowWriter.write(11, smj_value17);
/* 371 */         }
/* 372 */         append(project_result.copy());
/* 373 */
/* 374 */       }
/* 375 */       if (shouldStop()) return;
/* 376 */     }
/* 377 */   }
/* 378 */ }
