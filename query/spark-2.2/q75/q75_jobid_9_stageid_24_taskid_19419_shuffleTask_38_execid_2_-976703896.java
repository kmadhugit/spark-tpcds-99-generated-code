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
/* 012 */   private int smj_value8;
/* 013 */   private int smj_value9;
/* 014 */   private int smj_value10;
/* 015 */   private int smj_value11;
/* 016 */   private org.apache.spark.sql.execution.ExternalAppendOnlyUnsafeRowArray smj_matches;
/* 017 */   private int smj_value12;
/* 018 */   private int smj_value13;
/* 019 */   private int smj_value14;
/* 020 */   private int smj_value15;
/* 021 */   private int smj_value16;
/* 022 */   private boolean smj_isNull8;
/* 023 */   private int smj_value17;
/* 024 */   private boolean smj_isNull9;
/* 025 */   private int smj_value18;
/* 026 */   private boolean smj_isNull10;
/* 027 */   private int smj_value19;
/* 028 */   private boolean smj_isNull11;
/* 029 */   private int smj_value20;
/* 030 */   private boolean smj_isNull12;
/* 031 */   private long smj_value21;
/* 032 */   private boolean smj_isNull13;
/* 033 */   private double smj_value22;
/* 034 */   private boolean smj_isNull14;
/* 035 */   private org.apache.spark.sql.execution.metric.SQLMetric smj_numOutputRows;
/* 036 */   private UnsafeRow smj_result;
/* 037 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder smj_holder;
/* 038 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter smj_rowWriter;
/* 039 */   private UnsafeRow project_result;
/* 040 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 041 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 042 */
/* 043 */   public GeneratedIterator(Object[] references) {
/* 044 */     this.references = references;
/* 045 */   }
/* 046 */
/* 047 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 048 */     partitionIndex = index;
/* 049 */     this.inputs = inputs;
/* 050 */     smj_leftInput = inputs[0];
/* 051 */     smj_rightInput = inputs[1];
/* 052 */
/* 053 */     smj_rightRow = null;
/* 054 */
/* 055 */     smj_matches = new org.apache.spark.sql.execution.ExternalAppendOnlyUnsafeRowArray(2147483647);
/* 056 */
/* 057 */     this.smj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[0];
/* 058 */     smj_result = new UnsafeRow(14);
/* 059 */     this.smj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(smj_result, 0);
/* 060 */     this.smj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(smj_holder, 14);
/* 061 */     project_result = new UnsafeRow(10);
/* 062 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 0);
/* 063 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 10);
/* 064 */
/* 065 */   }
/* 066 */
/* 067 */   private boolean findNextInnerJoinRows(
/* 068 */     scala.collection.Iterator leftIter,
/* 069 */     scala.collection.Iterator rightIter) {
/* 070 */     smj_leftRow = null;
/* 071 */     int comp = 0;
/* 072 */     while (smj_leftRow == null) {
/* 073 */       if (!leftIter.hasNext()) return false;
/* 074 */       smj_leftRow = (InternalRow) leftIter.next();
/* 075 */
/* 076 */       boolean smj_isNull = smj_leftRow.isNullAt(1);
/* 077 */       int smj_value = smj_isNull ? -1 : (smj_leftRow.getInt(1));
/* 078 */
/* 079 */       boolean smj_isNull1 = smj_leftRow.isNullAt(2);
/* 080 */       int smj_value1 = smj_isNull1 ? -1 : (smj_leftRow.getInt(2));
/* 081 */
/* 082 */       boolean smj_isNull2 = smj_leftRow.isNullAt(3);
/* 083 */       int smj_value2 = smj_isNull2 ? -1 : (smj_leftRow.getInt(3));
/* 084 */
/* 085 */       boolean smj_isNull3 = smj_leftRow.isNullAt(4);
/* 086 */       int smj_value3 = smj_isNull3 ? -1 : (smj_leftRow.getInt(4));
/* 087 */       if (smj_isNull || smj_isNull1 || smj_isNull2 || smj_isNull3) {
/* 088 */         smj_leftRow = null;
/* 089 */         continue;
/* 090 */       }
/* 091 */       if (!smj_matches.isEmpty()) {
/* 092 */         comp = 0;
/* 093 */         if (comp == 0) {
/* 094 */           comp = (smj_value > smj_value12 ? 1 : smj_value < smj_value12 ? -1 : 0);
/* 095 */         }
/* 096 */         if (comp == 0) {
/* 097 */           comp = (smj_value1 > smj_value13 ? 1 : smj_value1 < smj_value13 ? -1 : 0);
/* 098 */         }
/* 099 */         if (comp == 0) {
/* 100 */           comp = (smj_value2 > smj_value14 ? 1 : smj_value2 < smj_value14 ? -1 : 0);
/* 101 */         }
/* 102 */         if (comp == 0) {
/* 103 */           comp = (smj_value3 > smj_value15 ? 1 : smj_value3 < smj_value15 ? -1 : 0);
/* 104 */         }
/* 105 */
/* 106 */         if (comp == 0) {
/* 107 */           return true;
/* 108 */         }
/* 109 */         smj_matches.clear();
/* 110 */       }
/* 111 */
/* 112 */       do {
/* 113 */         if (smj_rightRow == null) {
/* 114 */           if (!rightIter.hasNext()) {
/* 115 */             smj_value12 = smj_value;
/* 116 */             smj_value13 = smj_value1;
/* 117 */             smj_value14 = smj_value2;
/* 118 */             smj_value15 = smj_value3;
/* 119 */             return !smj_matches.isEmpty();
/* 120 */           }
/* 121 */           smj_rightRow = (InternalRow) rightIter.next();
/* 122 */
/* 123 */           boolean smj_isNull4 = smj_rightRow.isNullAt(1);
/* 124 */           int smj_value4 = smj_isNull4 ? -1 : (smj_rightRow.getInt(1));
/* 125 */
/* 126 */           boolean smj_isNull5 = smj_rightRow.isNullAt(2);
/* 127 */           int smj_value5 = smj_isNull5 ? -1 : (smj_rightRow.getInt(2));
/* 128 */
/* 129 */           boolean smj_isNull6 = smj_rightRow.isNullAt(3);
/* 130 */           int smj_value6 = smj_isNull6 ? -1 : (smj_rightRow.getInt(3));
/* 131 */
/* 132 */           boolean smj_isNull7 = smj_rightRow.isNullAt(4);
/* 133 */           int smj_value7 = smj_isNull7 ? -1 : (smj_rightRow.getInt(4));
/* 134 */           if (smj_isNull4 || smj_isNull5 || smj_isNull6 || smj_isNull7) {
/* 135 */             smj_rightRow = null;
/* 136 */             continue;
/* 137 */           }
/* 138 */           smj_value8 = smj_value4;
/* 139 */           smj_value9 = smj_value5;
/* 140 */           smj_value10 = smj_value6;
/* 141 */           smj_value11 = smj_value7;
/* 142 */         }
/* 143 */
/* 144 */         comp = 0;
/* 145 */         if (comp == 0) {
/* 146 */           comp = (smj_value > smj_value8 ? 1 : smj_value < smj_value8 ? -1 : 0);
/* 147 */         }
/* 148 */         if (comp == 0) {
/* 149 */           comp = (smj_value1 > smj_value9 ? 1 : smj_value1 < smj_value9 ? -1 : 0);
/* 150 */         }
/* 151 */         if (comp == 0) {
/* 152 */           comp = (smj_value2 > smj_value10 ? 1 : smj_value2 < smj_value10 ? -1 : 0);
/* 153 */         }
/* 154 */         if (comp == 0) {
/* 155 */           comp = (smj_value3 > smj_value11 ? 1 : smj_value3 < smj_value11 ? -1 : 0);
/* 156 */         }
/* 157 */
/* 158 */         if (comp > 0) {
/* 159 */           smj_rightRow = null;
/* 160 */         } else if (comp < 0) {
/* 161 */           if (!smj_matches.isEmpty()) {
/* 162 */             smj_value12 = smj_value;
/* 163 */             smj_value13 = smj_value1;
/* 164 */             smj_value14 = smj_value2;
/* 165 */             smj_value15 = smj_value3;
/* 166 */             return true;
/* 167 */           }
/* 168 */           smj_leftRow = null;
/* 169 */         } else {
/* 170 */           smj_matches.add((UnsafeRow) smj_rightRow);
/* 171 */           smj_rightRow = null;;
/* 172 */         }
/* 173 */       } while (smj_leftRow != null);
/* 174 */     }
/* 175 */     return false; // unreachable
/* 176 */   }
/* 177 */
/* 178 */   protected void processNext() throws java.io.IOException {
/* 179 */     while (findNextInnerJoinRows(smj_leftInput, smj_rightInput)) {
/* 180 */       boolean smj_loaded = false;
/* 181 */       smj_isNull13 = smj_leftRow.isNullAt(5);
/* 182 */       smj_value21 = smj_isNull13 ? -1L : (smj_leftRow.getLong(5));
/* 183 */       scala.collection.Iterator<UnsafeRow> smj_iterator = smj_matches.generateIterator();
/* 184 */       while (smj_iterator.hasNext()) {
/* 185 */         InternalRow smj_rightRow1 = (InternalRow) smj_iterator.next();
/* 186 */         boolean smj_isNull20 = smj_rightRow1.isNullAt(5);
/* 187 */         long smj_value28 = smj_isNull20 ? -1L : (smj_rightRow1.getLong(5));
/* 188 */
/* 189 */         boolean smj_isNull22 = true;
/* 190 */         boolean smj_value30 = false;
/* 191 */
/* 192 */         boolean smj_isNull28 = smj_isNull20;
/* 193 */         Decimal smj_value36 = null;
/* 194 */         if (!smj_isNull20) {
/* 195 */           Decimal smj_tmpDecimal1 = Decimal.apply((long) smj_value28);
/* 196 */
/* 197 */           if (smj_tmpDecimal1.changePrecision(17, 2)) {
/* 198 */             smj_value36 = smj_tmpDecimal1;
/* 199 */           } else {
/* 200 */             smj_isNull28 = true;
/* 201 */           }
/* 202 */
/* 203 */         }
/* 204 */         boolean smj_isNull25 = false;
/* 205 */         Decimal smj_value33 = null;
/* 206 */         if (smj_isNull28 || smj_value36.isZero()) {
/* 207 */           smj_isNull25 = true;
/* 208 */         } else {
/* 209 */           boolean smj_isNull26 = smj_isNull13;
/* 210 */           Decimal smj_value34 = null;
/* 211 */           if (!smj_isNull13) {
/* 212 */             Decimal smj_tmpDecimal = Decimal.apply((long) smj_value21);
/* 213 */
/* 214 */             if (smj_tmpDecimal.changePrecision(17, 2)) {
/* 215 */               smj_value34 = smj_tmpDecimal;
/* 216 */             } else {
/* 217 */               smj_isNull26 = true;
/* 218 */             }
/* 219 */
/* 220 */           }
/* 221 */           if (smj_isNull26) {
/* 222 */             smj_isNull25 = true;
/* 223 */           } else {
/* 224 */             smj_value33 = smj_value34.$div(smj_value36);
/* 225 */           }
/* 226 */         }
/* 227 */         boolean smj_isNull24 = smj_isNull25;
/* 228 */         Decimal smj_value32 = null;
/* 229 */
/* 230 */         if (!smj_isNull25) {
/* 231 */           Decimal smj_tmp = smj_value33.clone();
/* 232 */           if (smj_tmp.changePrecision(37, 20)) {
/* 233 */             smj_value32 = smj_tmp;
/* 234 */           } else {
/* 235 */             smj_isNull24 = true;
/* 236 */           }
/* 237 */
/* 238 */         }
/* 239 */         boolean smj_isNull23 = smj_isNull24;
/* 240 */         Decimal smj_value31 = null;
/* 241 */         if (!smj_isNull24) {
/* 242 */           Decimal smj_tmpDecimal2 = smj_value32.clone();
/* 243 */
/* 244 */           if (smj_tmpDecimal2.changePrecision(17, 2)) {
/* 245 */             smj_value31 = smj_tmpDecimal2;
/* 246 */           } else {
/* 247 */             smj_isNull23 = true;
/* 248 */           }
/* 249 */
/* 250 */         }
/* 251 */         if (!smj_isNull23) {
/* 252 */           smj_isNull22 = false; // resultCode could change nullability.
/* 253 */           smj_value30 = smj_value31.compare(((Decimal) references[1])) < 0;
/* 254 */
/* 255 */         }
/* 256 */         if (smj_isNull22 || !smj_value30) continue;
/* 257 */         if (!smj_loaded) {
/* 258 */           smj_loaded = true;
/* 259 */           smj_isNull8 = smj_leftRow.isNullAt(0);
/* 260 */           smj_value16 = smj_isNull8 ? -1 : (smj_leftRow.getInt(0));
/* 261 */           smj_isNull9 = smj_leftRow.isNullAt(1);
/* 262 */           smj_value17 = smj_isNull9 ? -1 : (smj_leftRow.getInt(1));
/* 263 */           smj_isNull10 = smj_leftRow.isNullAt(2);
/* 264 */           smj_value18 = smj_isNull10 ? -1 : (smj_leftRow.getInt(2));
/* 265 */           smj_isNull11 = smj_leftRow.isNullAt(3);
/* 266 */           smj_value19 = smj_isNull11 ? -1 : (smj_leftRow.getInt(3));
/* 267 */           smj_isNull12 = smj_leftRow.isNullAt(4);
/* 268 */           smj_value20 = smj_isNull12 ? -1 : (smj_leftRow.getInt(4));
/* 269 */           smj_isNull14 = smj_leftRow.isNullAt(6);
/* 270 */           smj_value22 = smj_isNull14 ? -1.0 : (smj_leftRow.getDouble(6));
/* 271 */         }
/* 272 */         boolean smj_isNull15 = smj_rightRow1.isNullAt(0);
/* 273 */         int smj_value23 = smj_isNull15 ? -1 : (smj_rightRow1.getInt(0));
/* 274 */         boolean smj_isNull16 = smj_rightRow1.isNullAt(1);
/* 275 */         int smj_value24 = smj_isNull16 ? -1 : (smj_rightRow1.getInt(1));
/* 276 */         boolean smj_isNull17 = smj_rightRow1.isNullAt(2);
/* 277 */         int smj_value25 = smj_isNull17 ? -1 : (smj_rightRow1.getInt(2));
/* 278 */         boolean smj_isNull18 = smj_rightRow1.isNullAt(3);
/* 279 */         int smj_value26 = smj_isNull18 ? -1 : (smj_rightRow1.getInt(3));
/* 280 */         boolean smj_isNull19 = smj_rightRow1.isNullAt(4);
/* 281 */         int smj_value27 = smj_isNull19 ? -1 : (smj_rightRow1.getInt(4));
/* 282 */         boolean smj_isNull21 = smj_rightRow1.isNullAt(6);
/* 283 */         double smj_value29 = smj_isNull21 ? -1.0 : (smj_rightRow1.getDouble(6));
/* 284 */         smj_numOutputRows.add(1);
/* 285 */
/* 286 */         boolean project_isNull8 = true;
/* 287 */         long project_value8 = -1L;
/* 288 */
/* 289 */         if (!smj_isNull13) {
/* 290 */           if (!smj_isNull20) {
/* 291 */             project_isNull8 = false; // resultCode could change nullability.
/* 292 */             project_value8 = smj_value21 - smj_value28;
/* 293 */
/* 294 */           }
/* 295 */
/* 296 */         }
/* 297 */         boolean project_isNull11 = true;
/* 298 */         double project_value11 = -1.0;
/* 299 */
/* 300 */         if (!smj_isNull14) {
/* 301 */           if (!smj_isNull21) {
/* 302 */             project_isNull11 = false; // resultCode could change nullability.
/* 303 */             project_value11 = smj_value22 - smj_value29;
/* 304 */
/* 305 */           }
/* 306 */
/* 307 */         }
/* 308 */         project_rowWriter.zeroOutNullBytes();
/* 309 */
/* 310 */         if (smj_isNull15) {
/* 311 */           project_rowWriter.setNullAt(0);
/* 312 */         } else {
/* 313 */           project_rowWriter.write(0, smj_value23);
/* 314 */         }
/* 315 */
/* 316 */         if (smj_isNull8) {
/* 317 */           project_rowWriter.setNullAt(1);
/* 318 */         } else {
/* 319 */           project_rowWriter.write(1, smj_value16);
/* 320 */         }
/* 321 */
/* 322 */         if (smj_isNull9) {
/* 323 */           project_rowWriter.setNullAt(2);
/* 324 */         } else {
/* 325 */           project_rowWriter.write(2, smj_value17);
/* 326 */         }
/* 327 */
/* 328 */         if (smj_isNull10) {
/* 329 */           project_rowWriter.setNullAt(3);
/* 330 */         } else {
/* 331 */           project_rowWriter.write(3, smj_value18);
/* 332 */         }
/* 333 */
/* 334 */         if (smj_isNull11) {
/* 335 */           project_rowWriter.setNullAt(4);
/* 336 */         } else {
/* 337 */           project_rowWriter.write(4, smj_value19);
/* 338 */         }
/* 339 */
/* 340 */         if (smj_isNull12) {
/* 341 */           project_rowWriter.setNullAt(5);
/* 342 */         } else {
/* 343 */           project_rowWriter.write(5, smj_value20);
/* 344 */         }
/* 345 */
/* 346 */         if (smj_isNull20) {
/* 347 */           project_rowWriter.setNullAt(6);
/* 348 */         } else {
/* 349 */           project_rowWriter.write(6, smj_value28);
/* 350 */         }
/* 351 */
/* 352 */         if (smj_isNull13) {
/* 353 */           project_rowWriter.setNullAt(7);
/* 354 */         } else {
/* 355 */           project_rowWriter.write(7, smj_value21);
/* 356 */         }
/* 357 */
/* 358 */         if (project_isNull8) {
/* 359 */           project_rowWriter.setNullAt(8);
/* 360 */         } else {
/* 361 */           project_rowWriter.write(8, project_value8);
/* 362 */         }
/* 363 */
/* 364 */         if (project_isNull11) {
/* 365 */           project_rowWriter.setNullAt(9);
/* 366 */         } else {
/* 367 */           project_rowWriter.write(9, project_value11);
/* 368 */         }
/* 369 */         append(project_result.copy());
/* 370 */
/* 371 */       }
/* 372 */       if (shouldStop()) return;
/* 373 */     }
/* 374 */   }
/* 375 */ }
