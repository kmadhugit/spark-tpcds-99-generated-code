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
/* 013 */   private UTF8String smj_value7;
/* 014 */   private UTF8String smj_value8;
/* 015 */   private org.apache.spark.sql.execution.ExternalAppendOnlyUnsafeRowArray smj_matches;
/* 016 */   private int smj_value9;
/* 017 */   private UTF8String smj_value10;
/* 018 */   private UTF8String smj_value11;
/* 019 */   private UTF8String smj_value12;
/* 020 */   private boolean smj_isNull6;
/* 021 */   private int smj_value13;
/* 022 */   private boolean smj_isNull7;
/* 023 */   private UTF8String smj_value14;
/* 024 */   private boolean smj_isNull8;
/* 025 */   private UTF8String smj_value15;
/* 026 */   private boolean smj_isNull9;
/* 027 */   private UTF8String smj_value16;
/* 028 */   private boolean smj_isNull10;
/* 029 */   private UTF8String smj_value17;
/* 030 */   private boolean smj_isNull11;
/* 031 */   private UTF8String smj_value18;
/* 032 */   private boolean smj_isNull12;
/* 033 */   private UTF8String smj_value19;
/* 034 */   private boolean smj_isNull13;
/* 035 */   private UTF8String smj_value20;
/* 036 */   private boolean smj_isNull14;
/* 037 */   private UTF8String smj_value21;
/* 038 */   private boolean smj_isNull15;
/* 039 */   private UTF8String smj_value22;
/* 040 */   private boolean smj_isNull16;
/* 041 */   private UTF8String smj_value23;
/* 042 */   private boolean smj_isNull17;
/* 043 */   private int smj_value24;
/* 044 */   private boolean smj_isNull18;
/* 045 */   private long smj_value25;
/* 046 */   private double smj_value26;
/* 047 */   private boolean smj_isNull19;
/* 048 */   private double smj_value27;
/* 049 */   private boolean smj_isNull20;
/* 050 */   private double smj_value28;
/* 051 */   private boolean smj_isNull21;
/* 052 */   private org.apache.spark.sql.execution.metric.SQLMetric smj_numOutputRows;
/* 053 */   private UnsafeRow smj_result;
/* 054 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder smj_holder;
/* 055 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter smj_rowWriter;
/* 056 */   private UnsafeRow project_result;
/* 057 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 058 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 059 */
/* 060 */   public GeneratedIterator(Object[] references) {
/* 061 */     this.references = references;
/* 062 */   }
/* 063 */
/* 064 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 065 */     partitionIndex = index;
/* 066 */     this.inputs = inputs;
/* 067 */     smj_leftInput = inputs[0];
/* 068 */     smj_rightInput = inputs[1];
/* 069 */
/* 070 */     smj_rightRow = null;
/* 071 */
/* 072 */     smj_matches = new org.apache.spark.sql.execution.ExternalAppendOnlyUnsafeRowArray(2147483647);
/* 073 */
/* 074 */     this.smj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[0];
/* 075 */     smj_result = new UnsafeRow(25);
/* 076 */     this.smj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(smj_result, 416);
/* 077 */     this.smj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(smj_holder, 25);
/* 078 */     project_result = new UnsafeRow(21);
/* 079 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 352);
/* 080 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 21);
/* 081 */
/* 082 */   }
/* 083 */
/* 084 */   private boolean findNextInnerJoinRows(
/* 085 */     scala.collection.Iterator leftIter,
/* 086 */     scala.collection.Iterator rightIter) {
/* 087 */     smj_leftRow = null;
/* 088 */     int comp = 0;
/* 089 */     while (smj_leftRow == null) {
/* 090 */       if (!leftIter.hasNext()) return false;
/* 091 */       smj_leftRow = (InternalRow) leftIter.next();
/* 092 */
/* 093 */       boolean smj_isNull = smj_leftRow.isNullAt(1);
/* 094 */       int smj_value = smj_isNull ? -1 : (smj_leftRow.getInt(1));
/* 095 */
/* 096 */       boolean smj_isNull1 = smj_leftRow.isNullAt(2);
/* 097 */       UTF8String smj_value1 = smj_isNull1 ? null : (smj_leftRow.getUTF8String(2));
/* 098 */
/* 099 */       boolean smj_isNull2 = smj_leftRow.isNullAt(3);
/* 100 */       UTF8String smj_value2 = smj_isNull2 ? null : (smj_leftRow.getUTF8String(3));
/* 101 */       if (smj_isNull || smj_isNull1 || smj_isNull2) {
/* 102 */         smj_leftRow = null;
/* 103 */         continue;
/* 104 */       }
/* 105 */       if (!smj_matches.isEmpty()) {
/* 106 */         comp = 0;
/* 107 */         if (comp == 0) {
/* 108 */           comp = (smj_value > smj_value9 ? 1 : smj_value < smj_value9 ? -1 : 0);
/* 109 */         }
/* 110 */         if (comp == 0) {
/* 111 */           comp = smj_value1.compare(smj_value10);
/* 112 */         }
/* 113 */         if (comp == 0) {
/* 114 */           comp = smj_value2.compare(smj_value11);
/* 115 */         }
/* 116 */
/* 117 */         if (comp == 0) {
/* 118 */           return true;
/* 119 */         }
/* 120 */         smj_matches.clear();
/* 121 */       }
/* 122 */
/* 123 */       do {
/* 124 */         if (smj_rightRow == null) {
/* 125 */           if (!rightIter.hasNext()) {
/* 126 */             smj_value9 = smj_value;
/* 127 */             smj_value10 = smj_value1.clone();
/* 128 */             smj_value11 = smj_value2.clone();
/* 129 */             return !smj_matches.isEmpty();
/* 130 */           }
/* 131 */           smj_rightRow = (InternalRow) rightIter.next();
/* 132 */
/* 133 */           boolean smj_isNull3 = smj_rightRow.isNullAt(0);
/* 134 */           int smj_value3 = smj_isNull3 ? -1 : (smj_rightRow.getInt(0));
/* 135 */
/* 136 */           boolean smj_isNull4 = smj_rightRow.isNullAt(1);
/* 137 */           UTF8String smj_value4 = smj_isNull4 ? null : (smj_rightRow.getUTF8String(1));
/* 138 */
/* 139 */           boolean smj_isNull5 = smj_rightRow.isNullAt(2);
/* 140 */           UTF8String smj_value5 = smj_isNull5 ? null : (smj_rightRow.getUTF8String(2));
/* 141 */           if (smj_isNull3 || smj_isNull4 || smj_isNull5) {
/* 142 */             smj_rightRow = null;
/* 143 */             continue;
/* 144 */           }
/* 145 */           smj_value6 = smj_value3;
/* 146 */           smj_value7 = smj_value4.clone();
/* 147 */           smj_value8 = smj_value5.clone();
/* 148 */         }
/* 149 */
/* 150 */         comp = 0;
/* 151 */         if (comp == 0) {
/* 152 */           comp = (smj_value > smj_value6 ? 1 : smj_value < smj_value6 ? -1 : 0);
/* 153 */         }
/* 154 */         if (comp == 0) {
/* 155 */           comp = smj_value1.compare(smj_value7);
/* 156 */         }
/* 157 */         if (comp == 0) {
/* 158 */           comp = smj_value2.compare(smj_value8);
/* 159 */         }
/* 160 */
/* 161 */         if (comp > 0) {
/* 162 */           smj_rightRow = null;
/* 163 */         } else if (comp < 0) {
/* 164 */           if (!smj_matches.isEmpty()) {
/* 165 */             smj_value9 = smj_value;
/* 166 */             smj_value10 = smj_value1.clone();
/* 167 */             smj_value11 = smj_value2.clone();
/* 168 */             return true;
/* 169 */           }
/* 170 */           smj_leftRow = null;
/* 171 */         } else {
/* 172 */           smj_matches.add((UnsafeRow) smj_rightRow);
/* 173 */           smj_rightRow = null;;
/* 174 */         }
/* 175 */       } while (smj_leftRow != null);
/* 176 */     }
/* 177 */     return false; // unreachable
/* 178 */   }
/* 179 */
/* 180 */   protected void processNext() throws java.io.IOException {
/* 181 */     while (findNextInnerJoinRows(smj_leftInput, smj_rightInput)) {
/* 182 */       boolean smj_loaded = false;
/* 183 */       smj_value25 = smj_leftRow.getLong(13);
/* 184 */       scala.collection.Iterator<UnsafeRow> smj_iterator = smj_matches.generateIterator();
/* 185 */       while (smj_iterator.hasNext()) {
/* 186 */         InternalRow smj_rightRow1 = (InternalRow) smj_iterator.next();
/* 187 */         long smj_value33 = smj_rightRow1.getLong(4);
/* 188 */
/* 189 */         boolean smj_isNull30 = false;
/* 190 */
/* 191 */         boolean smj_value37 = false;
/* 192 */         smj_value37 = smj_value33 <= smj_value25;
/* 193 */         if (false || !smj_value37) continue;
/* 194 */         if (!smj_loaded) {
/* 195 */           smj_loaded = true;
/* 196 */           smj_isNull6 = smj_leftRow.isNullAt(0);
/* 197 */           smj_value12 = smj_isNull6 ? null : (smj_leftRow.getUTF8String(0));
/* 198 */           smj_isNull7 = smj_leftRow.isNullAt(1);
/* 199 */           smj_value13 = smj_isNull7 ? -1 : (smj_leftRow.getInt(1));
/* 200 */           smj_isNull8 = smj_leftRow.isNullAt(2);
/* 201 */           smj_value14 = smj_isNull8 ? null : (smj_leftRow.getUTF8String(2));
/* 202 */           smj_isNull9 = smj_leftRow.isNullAt(3);
/* 203 */           smj_value15 = smj_isNull9 ? null : (smj_leftRow.getUTF8String(3));
/* 204 */           smj_isNull10 = smj_leftRow.isNullAt(4);
/* 205 */           smj_value16 = smj_isNull10 ? null : (smj_leftRow.getUTF8String(4));
/* 206 */           smj_isNull11 = smj_leftRow.isNullAt(5);
/* 207 */           smj_value17 = smj_isNull11 ? null : (smj_leftRow.getUTF8String(5));
/* 208 */           smj_isNull12 = smj_leftRow.isNullAt(6);
/* 209 */           smj_value18 = smj_isNull12 ? null : (smj_leftRow.getUTF8String(6));
/* 210 */           smj_isNull13 = smj_leftRow.isNullAt(7);
/* 211 */           smj_value19 = smj_isNull13 ? null : (smj_leftRow.getUTF8String(7));
/* 212 */           smj_isNull14 = smj_leftRow.isNullAt(8);
/* 213 */           smj_value20 = smj_isNull14 ? null : (smj_leftRow.getUTF8String(8));
/* 214 */           smj_isNull15 = smj_leftRow.isNullAt(9);
/* 215 */           smj_value21 = smj_isNull15 ? null : (smj_leftRow.getUTF8String(9));
/* 216 */           smj_isNull16 = smj_leftRow.isNullAt(10);
/* 217 */           smj_value22 = smj_isNull16 ? null : (smj_leftRow.getUTF8String(10));
/* 218 */           smj_isNull17 = smj_leftRow.isNullAt(11);
/* 219 */           smj_value23 = smj_isNull17 ? null : (smj_leftRow.getUTF8String(11));
/* 220 */           smj_isNull18 = smj_leftRow.isNullAt(12);
/* 221 */           smj_value24 = smj_isNull18 ? -1 : (smj_leftRow.getInt(12));
/* 222 */           smj_isNull19 = smj_leftRow.isNullAt(14);
/* 223 */           smj_value26 = smj_isNull19 ? -1.0 : (smj_leftRow.getDouble(14));
/* 224 */           smj_isNull20 = smj_leftRow.isNullAt(15);
/* 225 */           smj_value27 = smj_isNull20 ? -1.0 : (smj_leftRow.getDouble(15));
/* 226 */           smj_isNull21 = smj_leftRow.isNullAt(16);
/* 227 */           smj_value28 = smj_isNull21 ? -1.0 : (smj_leftRow.getDouble(16));
/* 228 */         }
/* 229 */         boolean smj_isNull22 = smj_rightRow1.isNullAt(0);
/* 230 */         int smj_value29 = smj_isNull22 ? -1 : (smj_rightRow1.getInt(0));
/* 231 */         boolean smj_isNull23 = smj_rightRow1.isNullAt(1);
/* 232 */         UTF8String smj_value30 = smj_isNull23 ? null : (smj_rightRow1.getUTF8String(1));
/* 233 */         boolean smj_isNull24 = smj_rightRow1.isNullAt(2);
/* 234 */         UTF8String smj_value31 = smj_isNull24 ? null : (smj_rightRow1.getUTF8String(2));
/* 235 */         boolean smj_isNull25 = smj_rightRow1.isNullAt(3);
/* 236 */         int smj_value32 = smj_isNull25 ? -1 : (smj_rightRow1.getInt(3));
/* 237 */         boolean smj_isNull27 = smj_rightRow1.isNullAt(5);
/* 238 */         double smj_value34 = smj_isNull27 ? -1.0 : (smj_rightRow1.getDouble(5));
/* 239 */         boolean smj_isNull28 = smj_rightRow1.isNullAt(6);
/* 240 */         double smj_value35 = smj_isNull28 ? -1.0 : (smj_rightRow1.getDouble(6));
/* 241 */         boolean smj_isNull29 = smj_rightRow1.isNullAt(7);
/* 242 */         double smj_value36 = smj_isNull29 ? -1.0 : (smj_rightRow1.getDouble(7));
/* 243 */         smj_numOutputRows.add(1);
/* 244 */
/* 245 */         project_holder.reset();
/* 246 */
/* 247 */         project_rowWriter.zeroOutNullBytes();
/* 248 */
/* 249 */         if (smj_isNull6) {
/* 250 */           project_rowWriter.setNullAt(0);
/* 251 */         } else {
/* 252 */           project_rowWriter.write(0, smj_value12);
/* 253 */         }
/* 254 */
/* 255 */         if (smj_isNull8) {
/* 256 */           project_rowWriter.setNullAt(1);
/* 257 */         } else {
/* 258 */           project_rowWriter.write(1, smj_value14);
/* 259 */         }
/* 260 */
/* 261 */         if (smj_isNull9) {
/* 262 */           project_rowWriter.setNullAt(2);
/* 263 */         } else {
/* 264 */           project_rowWriter.write(2, smj_value15);
/* 265 */         }
/* 266 */
/* 267 */         if (smj_isNull10) {
/* 268 */           project_rowWriter.setNullAt(3);
/* 269 */         } else {
/* 270 */           project_rowWriter.write(3, smj_value16);
/* 271 */         }
/* 272 */
/* 273 */         if (smj_isNull11) {
/* 274 */           project_rowWriter.setNullAt(4);
/* 275 */         } else {
/* 276 */           project_rowWriter.write(4, smj_value17);
/* 277 */         }
/* 278 */
/* 279 */         if (smj_isNull12) {
/* 280 */           project_rowWriter.setNullAt(5);
/* 281 */         } else {
/* 282 */           project_rowWriter.write(5, smj_value18);
/* 283 */         }
/* 284 */
/* 285 */         if (smj_isNull13) {
/* 286 */           project_rowWriter.setNullAt(6);
/* 287 */         } else {
/* 288 */           project_rowWriter.write(6, smj_value19);
/* 289 */         }
/* 290 */
/* 291 */         if (smj_isNull14) {
/* 292 */           project_rowWriter.setNullAt(7);
/* 293 */         } else {
/* 294 */           project_rowWriter.write(7, smj_value20);
/* 295 */         }
/* 296 */
/* 297 */         if (smj_isNull15) {
/* 298 */           project_rowWriter.setNullAt(8);
/* 299 */         } else {
/* 300 */           project_rowWriter.write(8, smj_value21);
/* 301 */         }
/* 302 */
/* 303 */         if (smj_isNull16) {
/* 304 */           project_rowWriter.setNullAt(9);
/* 305 */         } else {
/* 306 */           project_rowWriter.write(9, smj_value22);
/* 307 */         }
/* 308 */
/* 309 */         if (smj_isNull17) {
/* 310 */           project_rowWriter.setNullAt(10);
/* 311 */         } else {
/* 312 */           project_rowWriter.write(10, smj_value23);
/* 313 */         }
/* 314 */
/* 315 */         if (smj_isNull18) {
/* 316 */           project_rowWriter.setNullAt(11);
/* 317 */         } else {
/* 318 */           project_rowWriter.write(11, smj_value24);
/* 319 */         }
/* 320 */
/* 321 */         project_rowWriter.write(12, smj_value25);
/* 322 */
/* 323 */         if (smj_isNull19) {
/* 324 */           project_rowWriter.setNullAt(13);
/* 325 */         } else {
/* 326 */           project_rowWriter.write(13, smj_value26);
/* 327 */         }
/* 328 */
/* 329 */         if (smj_isNull20) {
/* 330 */           project_rowWriter.setNullAt(14);
/* 331 */         } else {
/* 332 */           project_rowWriter.write(14, smj_value27);
/* 333 */         }
/* 334 */
/* 335 */         if (smj_isNull21) {
/* 336 */           project_rowWriter.setNullAt(15);
/* 337 */         } else {
/* 338 */           project_rowWriter.write(15, smj_value28);
/* 339 */         }
/* 340 */
/* 341 */         if (smj_isNull27) {
/* 342 */           project_rowWriter.setNullAt(16);
/* 343 */         } else {
/* 344 */           project_rowWriter.write(16, smj_value34);
/* 345 */         }
/* 346 */
/* 347 */         if (smj_isNull28) {
/* 348 */           project_rowWriter.setNullAt(17);
/* 349 */         } else {
/* 350 */           project_rowWriter.write(17, smj_value35);
/* 351 */         }
/* 352 */
/* 353 */         if (smj_isNull29) {
/* 354 */           project_rowWriter.setNullAt(18);
/* 355 */         } else {
/* 356 */           project_rowWriter.write(18, smj_value36);
/* 357 */         }
/* 358 */
/* 359 */         if (smj_isNull25) {
/* 360 */           project_rowWriter.setNullAt(19);
/* 361 */         } else {
/* 362 */           project_rowWriter.write(19, smj_value32);
/* 363 */         }
/* 364 */
/* 365 */         project_rowWriter.write(20, smj_value33);
/* 366 */         project_result.setTotalSize(project_holder.totalSize());
/* 367 */         append(project_result.copy());
/* 368 */
/* 369 */       }
/* 370 */       if (shouldStop()) return;
/* 371 */     }
/* 372 */   }
/* 373 */ }
