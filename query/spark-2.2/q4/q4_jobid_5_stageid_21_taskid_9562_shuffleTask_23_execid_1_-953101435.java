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
/* 013 */   private org.apache.spark.sql.execution.ExternalAppendOnlyUnsafeRowArray smj_matches;
/* 014 */   private UTF8String smj_value3;
/* 015 */   private UTF8String smj_value4;
/* 016 */   private boolean smj_isNull2;
/* 017 */   private double smj_value5;
/* 018 */   private boolean smj_isNull3;
/* 019 */   private UTF8String smj_value6;
/* 020 */   private boolean smj_isNull4;
/* 021 */   private UTF8String smj_value7;
/* 022 */   private boolean smj_isNull5;
/* 023 */   private UTF8String smj_value8;
/* 024 */   private boolean smj_isNull6;
/* 025 */   private UTF8String smj_value9;
/* 026 */   private boolean smj_isNull7;
/* 027 */   private UTF8String smj_value10;
/* 028 */   private boolean smj_isNull8;
/* 029 */   private UTF8String smj_value11;
/* 030 */   private boolean smj_isNull9;
/* 031 */   private UTF8String smj_value12;
/* 032 */   private boolean smj_isNull10;
/* 033 */   private double smj_value13;
/* 034 */   private boolean smj_isNull11;
/* 035 */   private double smj_value14;
/* 036 */   private boolean smj_isNull12;
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
/* 060 */     smj_result = new UnsafeRow(13);
/* 061 */     this.smj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(smj_result, 288);
/* 062 */     this.smj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(smj_holder, 13);
/* 063 */     project_result = new UnsafeRow(10);
/* 064 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 256);
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
/* 078 */       boolean smj_isNull = smj_leftRow.isNullAt(0);
/* 079 */       UTF8String smj_value = smj_isNull ? null : (smj_leftRow.getUTF8String(0));
/* 080 */       if (smj_isNull) {
/* 081 */         smj_leftRow = null;
/* 082 */         continue;
/* 083 */       }
/* 084 */       if (!smj_matches.isEmpty()) {
/* 085 */         comp = 0;
/* 086 */         if (comp == 0) {
/* 087 */           comp = smj_value.compare(smj_value3);
/* 088 */         }
/* 089 */
/* 090 */         if (comp == 0) {
/* 091 */           return true;
/* 092 */         }
/* 093 */         smj_matches.clear();
/* 094 */       }
/* 095 */
/* 096 */       do {
/* 097 */         if (smj_rightRow == null) {
/* 098 */           if (!rightIter.hasNext()) {
/* 099 */             smj_value3 = smj_value.clone();
/* 100 */             return !smj_matches.isEmpty();
/* 101 */           }
/* 102 */           smj_rightRow = (InternalRow) rightIter.next();
/* 103 */
/* 104 */           boolean smj_isNull1 = smj_rightRow.isNullAt(0);
/* 105 */           UTF8String smj_value1 = smj_isNull1 ? null : (smj_rightRow.getUTF8String(0));
/* 106 */           if (smj_isNull1) {
/* 107 */             smj_rightRow = null;
/* 108 */             continue;
/* 109 */           }
/* 110 */           smj_value2 = smj_value1.clone();
/* 111 */         }
/* 112 */
/* 113 */         comp = 0;
/* 114 */         if (comp == 0) {
/* 115 */           comp = smj_value.compare(smj_value2);
/* 116 */         }
/* 117 */
/* 118 */         if (comp > 0) {
/* 119 */           smj_rightRow = null;
/* 120 */         } else if (comp < 0) {
/* 121 */           if (!smj_matches.isEmpty()) {
/* 122 */             smj_value3 = smj_value.clone();
/* 123 */             return true;
/* 124 */           }
/* 125 */           smj_leftRow = null;
/* 126 */         } else {
/* 127 */           smj_matches.add((UnsafeRow) smj_rightRow);
/* 128 */           smj_rightRow = null;;
/* 129 */         }
/* 130 */       } while (smj_leftRow != null);
/* 131 */     }
/* 132 */     return false; // unreachable
/* 133 */   }
/* 134 */
/* 135 */   protected void processNext() throws java.io.IOException {
/* 136 */     while (findNextInnerJoinRows(smj_leftInput, smj_rightInput)) {
/* 137 */       boolean smj_loaded = false;
/* 138 */       smj_isNull3 = smj_leftRow.isNullAt(1);
/* 139 */       smj_value5 = smj_isNull3 ? -1.0 : (smj_leftRow.getDouble(1));
/* 140 */       smj_isNull11 = smj_leftRow.isNullAt(9);
/* 141 */       smj_value13 = smj_isNull11 ? -1.0 : (smj_leftRow.getDouble(9));
/* 142 */       smj_isNull12 = smj_leftRow.isNullAt(10);
/* 143 */       smj_value14 = smj_isNull12 ? -1.0 : (smj_leftRow.getDouble(10));
/* 144 */       scala.collection.Iterator<UnsafeRow> smj_iterator = smj_matches.generateIterator();
/* 145 */       while (smj_iterator.hasNext()) {
/* 146 */         InternalRow smj_rightRow1 = (InternalRow) smj_iterator.next();
/* 147 */         boolean smj_isNull14 = smj_rightRow1.isNullAt(1);
/* 148 */         double smj_value16 = smj_isNull14 ? -1.0 : (smj_rightRow1.getDouble(1));
/* 149 */
/* 150 */         boolean smj_isNull15 = true;
/* 151 */         boolean smj_value17 = false;
/* 152 */
/* 153 */         boolean smj_isNull16 = true;
/* 154 */         double smj_value18 = -1.0;
/* 155 */
/* 156 */         boolean smj_isNull17 = true;
/* 157 */         boolean smj_value19 = false;
/* 158 */
/* 159 */         if (!smj_isNull12) {
/* 160 */           smj_isNull17 = false; // resultCode could change nullability.
/* 161 */           smj_value19 = org.apache.spark.util.Utils.nanSafeCompareDoubles(smj_value14, 0.0D) > 0;
/* 162 */
/* 163 */         }
/* 164 */         if (!smj_isNull17 && smj_value19) {
/* 165 */           boolean smj_isNull20 = false;
/* 166 */           double smj_value22 = -1.0;
/* 167 */           if (smj_isNull12 || smj_value14 == 0) {
/* 168 */             smj_isNull20 = true;
/* 169 */           } else {
/* 170 */             if (smj_isNull14) {
/* 171 */               smj_isNull20 = true;
/* 172 */             } else {
/* 173 */               smj_value22 = (double)(smj_value16 / smj_value14);
/* 174 */             }
/* 175 */           }
/* 176 */           smj_isNull16 = smj_isNull20;
/* 177 */           smj_value18 = smj_value22;
/* 178 */         }
/* 179 */
/* 180 */         else {
/* 181 */           final double smj_value25 = -1.0;
/* 182 */           smj_isNull16 = true;
/* 183 */           smj_value18 = smj_value25;
/* 184 */         }
/* 185 */         if (!smj_isNull16) {
/* 186 */           boolean smj_isNull24 = true;
/* 187 */           double smj_value26 = -1.0;
/* 188 */
/* 189 */           boolean smj_isNull25 = true;
/* 190 */           boolean smj_value27 = false;
/* 191 */
/* 192 */           if (!smj_isNull3) {
/* 193 */             smj_isNull25 = false; // resultCode could change nullability.
/* 194 */             smj_value27 = org.apache.spark.util.Utils.nanSafeCompareDoubles(smj_value5, 0.0D) > 0;
/* 195 */
/* 196 */           }
/* 197 */           if (!smj_isNull25 && smj_value27) {
/* 198 */             boolean smj_isNull28 = false;
/* 199 */             double smj_value30 = -1.0;
/* 200 */             if (smj_isNull3 || smj_value5 == 0) {
/* 201 */               smj_isNull28 = true;
/* 202 */             } else {
/* 203 */               if (smj_isNull11) {
/* 204 */                 smj_isNull28 = true;
/* 205 */               } else {
/* 206 */                 smj_value30 = (double)(smj_value13 / smj_value5);
/* 207 */               }
/* 208 */             }
/* 209 */             smj_isNull24 = smj_isNull28;
/* 210 */             smj_value26 = smj_value30;
/* 211 */           }
/* 212 */
/* 213 */           else {
/* 214 */             final double smj_value33 = -1.0;
/* 215 */             smj_isNull24 = true;
/* 216 */             smj_value26 = smj_value33;
/* 217 */           }
/* 218 */           if (!smj_isNull24) {
/* 219 */             smj_isNull15 = false; // resultCode could change nullability.
/* 220 */             smj_value17 = org.apache.spark.util.Utils.nanSafeCompareDoubles(smj_value18, smj_value26) > 0;
/* 221 */
/* 222 */           }
/* 223 */
/* 224 */         }
/* 225 */         if (smj_isNull15 || !smj_value17) continue;
/* 226 */         if (!smj_loaded) {
/* 227 */           smj_loaded = true;
/* 228 */           smj_isNull2 = smj_leftRow.isNullAt(0);
/* 229 */           smj_value4 = smj_isNull2 ? null : (smj_leftRow.getUTF8String(0));
/* 230 */           smj_isNull4 = smj_leftRow.isNullAt(2);
/* 231 */           smj_value6 = smj_isNull4 ? null : (smj_leftRow.getUTF8String(2));
/* 232 */           smj_isNull5 = smj_leftRow.isNullAt(3);
/* 233 */           smj_value7 = smj_isNull5 ? null : (smj_leftRow.getUTF8String(3));
/* 234 */           smj_isNull6 = smj_leftRow.isNullAt(4);
/* 235 */           smj_value8 = smj_isNull6 ? null : (smj_leftRow.getUTF8String(4));
/* 236 */           smj_isNull7 = smj_leftRow.isNullAt(5);
/* 237 */           smj_value9 = smj_isNull7 ? null : (smj_leftRow.getUTF8String(5));
/* 238 */           smj_isNull8 = smj_leftRow.isNullAt(6);
/* 239 */           smj_value10 = smj_isNull8 ? null : (smj_leftRow.getUTF8String(6));
/* 240 */           smj_isNull9 = smj_leftRow.isNullAt(7);
/* 241 */           smj_value11 = smj_isNull9 ? null : (smj_leftRow.getUTF8String(7));
/* 242 */           smj_isNull10 = smj_leftRow.isNullAt(8);
/* 243 */           smj_value12 = smj_isNull10 ? null : (smj_leftRow.getUTF8String(8));
/* 244 */         }
/* 245 */         boolean smj_isNull13 = smj_rightRow1.isNullAt(0);
/* 246 */         UTF8String smj_value15 = smj_isNull13 ? null : (smj_rightRow1.getUTF8String(0));
/* 247 */         smj_numOutputRows.add(1);
/* 248 */
/* 249 */         project_holder.reset();
/* 250 */
/* 251 */         project_rowWriter.zeroOutNullBytes();
/* 252 */
/* 253 */         if (smj_isNull2) {
/* 254 */           project_rowWriter.setNullAt(0);
/* 255 */         } else {
/* 256 */           project_rowWriter.write(0, smj_value4);
/* 257 */         }
/* 258 */
/* 259 */         if (smj_isNull4) {
/* 260 */           project_rowWriter.setNullAt(1);
/* 261 */         } else {
/* 262 */           project_rowWriter.write(1, smj_value6);
/* 263 */         }
/* 264 */
/* 265 */         if (smj_isNull5) {
/* 266 */           project_rowWriter.setNullAt(2);
/* 267 */         } else {
/* 268 */           project_rowWriter.write(2, smj_value7);
/* 269 */         }
/* 270 */
/* 271 */         if (smj_isNull6) {
/* 272 */           project_rowWriter.setNullAt(3);
/* 273 */         } else {
/* 274 */           project_rowWriter.write(3, smj_value8);
/* 275 */         }
/* 276 */
/* 277 */         if (smj_isNull7) {
/* 278 */           project_rowWriter.setNullAt(4);
/* 279 */         } else {
/* 280 */           project_rowWriter.write(4, smj_value9);
/* 281 */         }
/* 282 */
/* 283 */         if (smj_isNull8) {
/* 284 */           project_rowWriter.setNullAt(5);
/* 285 */         } else {
/* 286 */           project_rowWriter.write(5, smj_value10);
/* 287 */         }
/* 288 */
/* 289 */         if (smj_isNull9) {
/* 290 */           project_rowWriter.setNullAt(6);
/* 291 */         } else {
/* 292 */           project_rowWriter.write(6, smj_value11);
/* 293 */         }
/* 294 */
/* 295 */         if (smj_isNull10) {
/* 296 */           project_rowWriter.setNullAt(7);
/* 297 */         } else {
/* 298 */           project_rowWriter.write(7, smj_value12);
/* 299 */         }
/* 300 */
/* 301 */         if (smj_isNull12) {
/* 302 */           project_rowWriter.setNullAt(8);
/* 303 */         } else {
/* 304 */           project_rowWriter.write(8, smj_value14);
/* 305 */         }
/* 306 */
/* 307 */         if (smj_isNull14) {
/* 308 */           project_rowWriter.setNullAt(9);
/* 309 */         } else {
/* 310 */           project_rowWriter.write(9, smj_value16);
/* 311 */         }
/* 312 */         project_result.setTotalSize(project_holder.totalSize());
/* 313 */         append(project_result.copy());
/* 314 */
/* 315 */       }
/* 316 */       if (shouldStop()) return;
/* 317 */     }
/* 318 */   }
/* 319 */ }
