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
/* 012 */   private UTF8String smj_value6;
/* 013 */   private int smj_value7;
/* 014 */   private org.apache.spark.sql.execution.ExternalAppendOnlyUnsafeRowArray smj_matches;
/* 015 */   private UTF8String smj_value8;
/* 016 */   private int smj_value9;
/* 017 */   private UTF8String smj_value10;
/* 018 */   private boolean smj_isNull6;
/* 019 */   private int smj_value11;
/* 020 */   private boolean smj_isNull7;
/* 021 */   private UTF8String smj_value12;
/* 022 */   private boolean smj_isNull8;
/* 023 */   private double smj_value13;
/* 024 */   private boolean smj_isNull9;
/* 025 */   private double smj_value14;
/* 026 */   private boolean smj_isNull10;
/* 027 */   private double smj_value15;
/* 028 */   private boolean smj_isNull11;
/* 029 */   private double smj_value16;
/* 030 */   private boolean smj_isNull12;
/* 031 */   private double smj_value17;
/* 032 */   private boolean smj_isNull13;
/* 033 */   private double smj_value18;
/* 034 */   private boolean smj_isNull14;
/* 035 */   private double smj_value19;
/* 036 */   private boolean smj_isNull15;
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
/* 060 */     smj_result = new UnsafeRow(19);
/* 061 */     this.smj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(smj_result, 96);
/* 062 */     this.smj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(smj_holder, 19);
/* 063 */     project_result = new UnsafeRow(10);
/* 064 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 64);
/* 065 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 10);
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
/* 078 */       boolean smj_isNull = smj_leftRow.isNullAt(2);
/* 079 */       UTF8String smj_value = smj_isNull ? null : (smj_leftRow.getUTF8String(2));
/* 080 */
/* 081 */       boolean smj_isNull1 = smj_leftRow.isNullAt(1);
/* 082 */       int smj_value1 = smj_isNull1 ? -1 : (smj_leftRow.getInt(1));
/* 083 */       if (smj_isNull || smj_isNull1) {
/* 084 */         smj_leftRow = null;
/* 085 */         continue;
/* 086 */       }
/* 087 */       if (!smj_matches.isEmpty()) {
/* 088 */         comp = 0;
/* 089 */         if (comp == 0) {
/* 090 */           comp = smj_value.compare(smj_value8);
/* 091 */         }
/* 092 */         if (comp == 0) {
/* 093 */           comp = (smj_value1 > smj_value9 ? 1 : smj_value1 < smj_value9 ? -1 : 0);
/* 094 */         }
/* 095 */
/* 096 */         if (comp == 0) {
/* 097 */           return true;
/* 098 */         }
/* 099 */         smj_matches.clear();
/* 100 */       }
/* 101 */
/* 102 */       do {
/* 103 */         if (smj_rightRow == null) {
/* 104 */           if (!rightIter.hasNext()) {
/* 105 */             smj_value8 = smj_value.clone();
/* 106 */             smj_value9 = smj_value1;
/* 107 */             return !smj_matches.isEmpty();
/* 108 */           }
/* 109 */           smj_rightRow = (InternalRow) rightIter.next();
/* 110 */
/* 111 */           boolean smj_isNull2 = smj_rightRow.isNullAt(1);
/* 112 */           UTF8String smj_value2 = smj_isNull2 ? null : (smj_rightRow.getUTF8String(1));
/* 113 */
/* 114 */           boolean smj_isNull3 = true;
/* 115 */           int smj_value3 = -1;
/* 116 */
/* 117 */           boolean smj_isNull4 = smj_rightRow.isNullAt(0);
/* 118 */           int smj_value4 = smj_isNull4 ? -1 : (smj_rightRow.getInt(0));
/* 119 */           if (!smj_isNull4) {
/* 120 */             smj_isNull3 = false; // resultCode could change nullability.
/* 121 */             smj_value3 = smj_value4 - 52;
/* 122 */
/* 123 */           }
/* 124 */           if (smj_isNull2 || smj_isNull3) {
/* 125 */             smj_rightRow = null;
/* 126 */             continue;
/* 127 */           }
/* 128 */           smj_value6 = smj_value2.clone();
/* 129 */           smj_value7 = smj_value3;
/* 130 */         }
/* 131 */
/* 132 */         comp = 0;
/* 133 */         if (comp == 0) {
/* 134 */           comp = smj_value.compare(smj_value6);
/* 135 */         }
/* 136 */         if (comp == 0) {
/* 137 */           comp = (smj_value1 > smj_value7 ? 1 : smj_value1 < smj_value7 ? -1 : 0);
/* 138 */         }
/* 139 */
/* 140 */         if (comp > 0) {
/* 141 */           smj_rightRow = null;
/* 142 */         } else if (comp < 0) {
/* 143 */           if (!smj_matches.isEmpty()) {
/* 144 */             smj_value8 = smj_value.clone();
/* 145 */             smj_value9 = smj_value1;
/* 146 */             return true;
/* 147 */           }
/* 148 */           smj_leftRow = null;
/* 149 */         } else {
/* 150 */           smj_matches.add((UnsafeRow) smj_rightRow);
/* 151 */           smj_rightRow = null;;
/* 152 */         }
/* 153 */       } while (smj_leftRow != null);
/* 154 */     }
/* 155 */     return false; // unreachable
/* 156 */   }
/* 157 */
/* 158 */   protected void processNext() throws java.io.IOException {
/* 159 */     while (findNextInnerJoinRows(smj_leftInput, smj_rightInput)) {
/* 160 */       smj_isNull6 = smj_leftRow.isNullAt(0);
/* 161 */       smj_value10 = smj_isNull6 ? null : (smj_leftRow.getUTF8String(0));
/* 162 */       smj_isNull7 = smj_leftRow.isNullAt(1);
/* 163 */       smj_value11 = smj_isNull7 ? -1 : (smj_leftRow.getInt(1));
/* 164 */       smj_isNull8 = smj_leftRow.isNullAt(2);
/* 165 */       smj_value12 = smj_isNull8 ? null : (smj_leftRow.getUTF8String(2));
/* 166 */       smj_isNull9 = smj_leftRow.isNullAt(3);
/* 167 */       smj_value13 = smj_isNull9 ? -1.0 : (smj_leftRow.getDouble(3));
/* 168 */       smj_isNull10 = smj_leftRow.isNullAt(4);
/* 169 */       smj_value14 = smj_isNull10 ? -1.0 : (smj_leftRow.getDouble(4));
/* 170 */       smj_isNull11 = smj_leftRow.isNullAt(5);
/* 171 */       smj_value15 = smj_isNull11 ? -1.0 : (smj_leftRow.getDouble(5));
/* 172 */       smj_isNull12 = smj_leftRow.isNullAt(6);
/* 173 */       smj_value16 = smj_isNull12 ? -1.0 : (smj_leftRow.getDouble(6));
/* 174 */       smj_isNull13 = smj_leftRow.isNullAt(7);
/* 175 */       smj_value17 = smj_isNull13 ? -1.0 : (smj_leftRow.getDouble(7));
/* 176 */       smj_isNull14 = smj_leftRow.isNullAt(8);
/* 177 */       smj_value18 = smj_isNull14 ? -1.0 : (smj_leftRow.getDouble(8));
/* 178 */       smj_isNull15 = smj_leftRow.isNullAt(9);
/* 179 */       smj_value19 = smj_isNull15 ? -1.0 : (smj_leftRow.getDouble(9));
/* 180 */       scala.collection.Iterator<UnsafeRow> smj_iterator = smj_matches.generateIterator();
/* 181 */       while (smj_iterator.hasNext()) {
/* 182 */         InternalRow smj_rightRow1 = (InternalRow) smj_iterator.next();
/* 183 */
/* 184 */         smj_numOutputRows.add(1);
/* 185 */
/* 186 */         boolean smj_isNull18 = smj_rightRow1.isNullAt(2);
/* 187 */         double smj_value22 = smj_isNull18 ? -1.0 : (smj_rightRow1.getDouble(2));
/* 188 */         boolean project_isNull3 = false;
/* 189 */         double project_value3 = -1.0;
/* 190 */         if (smj_isNull18 || smj_value22 == 0) {
/* 191 */           project_isNull3 = true;
/* 192 */         } else {
/* 193 */           if (smj_isNull9) {
/* 194 */             project_isNull3 = true;
/* 195 */           } else {
/* 196 */             project_value3 = (double)(smj_value13 / smj_value22);
/* 197 */           }
/* 198 */         }
/* 199 */         boolean smj_isNull19 = smj_rightRow1.isNullAt(3);
/* 200 */         double smj_value23 = smj_isNull19 ? -1.0 : (smj_rightRow1.getDouble(3));
/* 201 */         boolean project_isNull6 = false;
/* 202 */         double project_value6 = -1.0;
/* 203 */         if (smj_isNull19 || smj_value23 == 0) {
/* 204 */           project_isNull6 = true;
/* 205 */         } else {
/* 206 */           if (smj_isNull10) {
/* 207 */             project_isNull6 = true;
/* 208 */           } else {
/* 209 */             project_value6 = (double)(smj_value14 / smj_value23);
/* 210 */           }
/* 211 */         }
/* 212 */         boolean smj_isNull20 = smj_rightRow1.isNullAt(4);
/* 213 */         double smj_value24 = smj_isNull20 ? -1.0 : (smj_rightRow1.getDouble(4));
/* 214 */         boolean project_isNull9 = false;
/* 215 */         double project_value9 = -1.0;
/* 216 */         if (smj_isNull20 || smj_value24 == 0) {
/* 217 */           project_isNull9 = true;
/* 218 */         } else {
/* 219 */           if (smj_isNull11) {
/* 220 */             project_isNull9 = true;
/* 221 */           } else {
/* 222 */             project_value9 = (double)(smj_value15 / smj_value24);
/* 223 */           }
/* 224 */         }
/* 225 */         boolean smj_isNull21 = smj_rightRow1.isNullAt(5);
/* 226 */         double smj_value25 = smj_isNull21 ? -1.0 : (smj_rightRow1.getDouble(5));
/* 227 */         boolean project_isNull12 = false;
/* 228 */         double project_value12 = -1.0;
/* 229 */         if (smj_isNull21 || smj_value25 == 0) {
/* 230 */           project_isNull12 = true;
/* 231 */         } else {
/* 232 */           if (smj_isNull12) {
/* 233 */             project_isNull12 = true;
/* 234 */           } else {
/* 235 */             project_value12 = (double)(smj_value16 / smj_value25);
/* 236 */           }
/* 237 */         }
/* 238 */         boolean smj_isNull22 = smj_rightRow1.isNullAt(6);
/* 239 */         double smj_value26 = smj_isNull22 ? -1.0 : (smj_rightRow1.getDouble(6));
/* 240 */         boolean project_isNull15 = false;
/* 241 */         double project_value15 = -1.0;
/* 242 */         if (smj_isNull22 || smj_value26 == 0) {
/* 243 */           project_isNull15 = true;
/* 244 */         } else {
/* 245 */           if (smj_isNull13) {
/* 246 */             project_isNull15 = true;
/* 247 */           } else {
/* 248 */             project_value15 = (double)(smj_value17 / smj_value26);
/* 249 */           }
/* 250 */         }
/* 251 */         boolean smj_isNull23 = smj_rightRow1.isNullAt(7);
/* 252 */         double smj_value27 = smj_isNull23 ? -1.0 : (smj_rightRow1.getDouble(7));
/* 253 */         boolean project_isNull18 = false;
/* 254 */         double project_value18 = -1.0;
/* 255 */         if (smj_isNull23 || smj_value27 == 0) {
/* 256 */           project_isNull18 = true;
/* 257 */         } else {
/* 258 */           if (smj_isNull14) {
/* 259 */             project_isNull18 = true;
/* 260 */           } else {
/* 261 */             project_value18 = (double)(smj_value18 / smj_value27);
/* 262 */           }
/* 263 */         }
/* 264 */         boolean smj_isNull24 = smj_rightRow1.isNullAt(8);
/* 265 */         double smj_value28 = smj_isNull24 ? -1.0 : (smj_rightRow1.getDouble(8));
/* 266 */         boolean project_isNull21 = false;
/* 267 */         double project_value21 = -1.0;
/* 268 */         if (smj_isNull24 || smj_value28 == 0) {
/* 269 */           project_isNull21 = true;
/* 270 */         } else {
/* 271 */           if (smj_isNull15) {
/* 272 */             project_isNull21 = true;
/* 273 */           } else {
/* 274 */             project_value21 = (double)(smj_value19 / smj_value28);
/* 275 */           }
/* 276 */         }
/* 277 */         project_holder.reset();
/* 278 */
/* 279 */         project_rowWriter.zeroOutNullBytes();
/* 280 */
/* 281 */         if (smj_isNull6) {
/* 282 */           project_rowWriter.setNullAt(0);
/* 283 */         } else {
/* 284 */           project_rowWriter.write(0, smj_value10);
/* 285 */         }
/* 286 */
/* 287 */         if (smj_isNull8) {
/* 288 */           project_rowWriter.setNullAt(1);
/* 289 */         } else {
/* 290 */           project_rowWriter.write(1, smj_value12);
/* 291 */         }
/* 292 */
/* 293 */         if (smj_isNull7) {
/* 294 */           project_rowWriter.setNullAt(2);
/* 295 */         } else {
/* 296 */           project_rowWriter.write(2, smj_value11);
/* 297 */         }
/* 298 */
/* 299 */         if (project_isNull3) {
/* 300 */           project_rowWriter.setNullAt(3);
/* 301 */         } else {
/* 302 */           project_rowWriter.write(3, project_value3);
/* 303 */         }
/* 304 */
/* 305 */         if (project_isNull6) {
/* 306 */           project_rowWriter.setNullAt(4);
/* 307 */         } else {
/* 308 */           project_rowWriter.write(4, project_value6);
/* 309 */         }
/* 310 */
/* 311 */         if (project_isNull9) {
/* 312 */           project_rowWriter.setNullAt(5);
/* 313 */         } else {
/* 314 */           project_rowWriter.write(5, project_value9);
/* 315 */         }
/* 316 */
/* 317 */         if (project_isNull12) {
/* 318 */           project_rowWriter.setNullAt(6);
/* 319 */         } else {
/* 320 */           project_rowWriter.write(6, project_value12);
/* 321 */         }
/* 322 */
/* 323 */         if (project_isNull15) {
/* 324 */           project_rowWriter.setNullAt(7);
/* 325 */         } else {
/* 326 */           project_rowWriter.write(7, project_value15);
/* 327 */         }
/* 328 */
/* 329 */         if (project_isNull18) {
/* 330 */           project_rowWriter.setNullAt(8);
/* 331 */         } else {
/* 332 */           project_rowWriter.write(8, project_value18);
/* 333 */         }
/* 334 */
/* 335 */         if (project_isNull21) {
/* 336 */           project_rowWriter.setNullAt(9);
/* 337 */         } else {
/* 338 */           project_rowWriter.write(9, project_value21);
/* 339 */         }
/* 340 */         project_result.setTotalSize(project_holder.totalSize());
/* 341 */         append(project_result.copy());
/* 342 */
/* 343 */       }
/* 344 */       if (shouldStop()) return;
/* 345 */     }
/* 346 */   }
/* 347 */ }
