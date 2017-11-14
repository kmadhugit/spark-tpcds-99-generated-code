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
/* 012 */   private UTF8String smj_value12;
/* 013 */   private UTF8String smj_value13;
/* 014 */   private UTF8String smj_value14;
/* 015 */   private UTF8String smj_value15;
/* 016 */   private int smj_value16;
/* 017 */   private org.apache.spark.sql.execution.ExternalAppendOnlyUnsafeRowArray smj_matches;
/* 018 */   private UTF8String smj_value17;
/* 019 */   private UTF8String smj_value18;
/* 020 */   private UTF8String smj_value19;
/* 021 */   private UTF8String smj_value20;
/* 022 */   private int smj_value21;
/* 023 */   private UTF8String smj_value22;
/* 024 */   private boolean smj_isNull12;
/* 025 */   private UTF8String smj_value23;
/* 026 */   private boolean smj_isNull13;
/* 027 */   private UTF8String smj_value24;
/* 028 */   private boolean smj_isNull14;
/* 029 */   private UTF8String smj_value25;
/* 030 */   private boolean smj_isNull15;
/* 031 */   private int smj_value26;
/* 032 */   private int smj_value27;
/* 033 */   private boolean smj_isNull16;
/* 034 */   private double smj_value28;
/* 035 */   private boolean smj_isNull17;
/* 036 */   private double smj_value29;
/* 037 */   private int smj_value30;
/* 038 */   private org.apache.spark.sql.execution.metric.SQLMetric smj_numOutputRows;
/* 039 */   private UnsafeRow smj_result;
/* 040 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder smj_holder;
/* 041 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter smj_rowWriter;
/* 042 */   private UnsafeRow project_result;
/* 043 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 044 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 045 */
/* 046 */   public GeneratedIterator(Object[] references) {
/* 047 */     this.references = references;
/* 048 */   }
/* 049 */
/* 050 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 051 */     partitionIndex = index;
/* 052 */     this.inputs = inputs;
/* 053 */     smj_leftInput = inputs[0];
/* 054 */     smj_rightInput = inputs[1];
/* 055 */
/* 056 */     smj_rightRow = null;
/* 057 */
/* 058 */     smj_matches = new org.apache.spark.sql.execution.ExternalAppendOnlyUnsafeRowArray(2147483647);
/* 059 */
/* 060 */     this.smj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[0];
/* 061 */     smj_result = new UnsafeRow(15);
/* 062 */     this.smj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(smj_result, 256);
/* 063 */     this.smj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(smj_holder, 15);
/* 064 */     project_result = new UnsafeRow(10);
/* 065 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 128);
/* 066 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 10);
/* 067 */
/* 068 */   }
/* 069 */
/* 070 */   private boolean findNextInnerJoinRows(
/* 071 */     scala.collection.Iterator leftIter,
/* 072 */     scala.collection.Iterator rightIter) {
/* 073 */     smj_leftRow = null;
/* 074 */     int comp = 0;
/* 075 */     while (smj_leftRow == null) {
/* 076 */       if (!leftIter.hasNext()) return false;
/* 077 */       smj_leftRow = (InternalRow) leftIter.next();
/* 078 */
/* 079 */       boolean smj_isNull = smj_leftRow.isNullAt(0);
/* 080 */       UTF8String smj_value = smj_isNull ? null : (smj_leftRow.getUTF8String(0));
/* 081 */
/* 082 */       boolean smj_isNull1 = smj_leftRow.isNullAt(1);
/* 083 */       UTF8String smj_value1 = smj_isNull1 ? null : (smj_leftRow.getUTF8String(1));
/* 084 */
/* 085 */       boolean smj_isNull2 = smj_leftRow.isNullAt(2);
/* 086 */       UTF8String smj_value2 = smj_isNull2 ? null : (smj_leftRow.getUTF8String(2));
/* 087 */
/* 088 */       boolean smj_isNull3 = smj_leftRow.isNullAt(3);
/* 089 */       UTF8String smj_value3 = smj_isNull3 ? null : (smj_leftRow.getUTF8String(3));
/* 090 */
/* 091 */       int smj_value4 = smj_leftRow.getInt(8);
/* 092 */       if (smj_isNull || smj_isNull1 || smj_isNull2 || smj_isNull3 || false) {
/* 093 */         smj_leftRow = null;
/* 094 */         continue;
/* 095 */       }
/* 096 */       if (!smj_matches.isEmpty()) {
/* 097 */         comp = 0;
/* 098 */         if (comp == 0) {
/* 099 */           comp = smj_value.compare(smj_value17);
/* 100 */         }
/* 101 */         if (comp == 0) {
/* 102 */           comp = smj_value1.compare(smj_value18);
/* 103 */         }
/* 104 */         if (comp == 0) {
/* 105 */           comp = smj_value2.compare(smj_value19);
/* 106 */         }
/* 107 */         if (comp == 0) {
/* 108 */           comp = smj_value3.compare(smj_value20);
/* 109 */         }
/* 110 */         if (comp == 0) {
/* 111 */           comp = (smj_value4 > smj_value21 ? 1 : smj_value4 < smj_value21 ? -1 : 0);
/* 112 */         }
/* 113 */
/* 114 */         if (comp == 0) {
/* 115 */           return true;
/* 116 */         }
/* 117 */         smj_matches.clear();
/* 118 */       }
/* 119 */
/* 120 */       do {
/* 121 */         if (smj_rightRow == null) {
/* 122 */           if (!rightIter.hasNext()) {
/* 123 */             smj_value17 = smj_value.clone();
/* 124 */             smj_value18 = smj_value1.clone();
/* 125 */             smj_value19 = smj_value2.clone();
/* 126 */             smj_value20 = smj_value3.clone();
/* 127 */             smj_value21 = smj_value4;
/* 128 */             return !smj_matches.isEmpty();
/* 129 */           }
/* 130 */           smj_rightRow = (InternalRow) rightIter.next();
/* 131 */
/* 132 */           boolean smj_isNull5 = smj_rightRow.isNullAt(0);
/* 133 */           UTF8String smj_value5 = smj_isNull5 ? null : (smj_rightRow.getUTF8String(0));
/* 134 */
/* 135 */           boolean smj_isNull6 = smj_rightRow.isNullAt(1);
/* 136 */           UTF8String smj_value6 = smj_isNull6 ? null : (smj_rightRow.getUTF8String(1));
/* 137 */
/* 138 */           boolean smj_isNull7 = smj_rightRow.isNullAt(2);
/* 139 */           UTF8String smj_value7 = smj_isNull7 ? null : (smj_rightRow.getUTF8String(2));
/* 140 */
/* 141 */           boolean smj_isNull8 = smj_rightRow.isNullAt(3);
/* 142 */           UTF8String smj_value8 = smj_isNull8 ? null : (smj_rightRow.getUTF8String(3));
/* 143 */
/* 144 */           boolean smj_isNull9 = true;
/* 145 */           int smj_value9 = -1;
/* 146 */
/* 147 */           boolean smj_isNull10 = smj_rightRow.isNullAt(5);
/* 148 */           int smj_value10 = smj_isNull10 ? -1 : (smj_rightRow.getInt(5));
/* 149 */           if (!smj_isNull10) {
/* 150 */             smj_isNull9 = false; // resultCode could change nullability.
/* 151 */             smj_value9 = smj_value10 + 1;
/* 152 */
/* 153 */           }
/* 154 */           if (smj_isNull5 || smj_isNull6 || smj_isNull7 || smj_isNull8 || smj_isNull9) {
/* 155 */             smj_rightRow = null;
/* 156 */             continue;
/* 157 */           }
/* 158 */           smj_value12 = smj_value5.clone();
/* 159 */           smj_value13 = smj_value6.clone();
/* 160 */           smj_value14 = smj_value7.clone();
/* 161 */           smj_value15 = smj_value8.clone();
/* 162 */           smj_value16 = smj_value9;
/* 163 */         }
/* 164 */
/* 165 */         comp = 0;
/* 166 */         if (comp == 0) {
/* 167 */           comp = smj_value.compare(smj_value12);
/* 168 */         }
/* 169 */         if (comp == 0) {
/* 170 */           comp = smj_value1.compare(smj_value13);
/* 171 */         }
/* 172 */         if (comp == 0) {
/* 173 */           comp = smj_value2.compare(smj_value14);
/* 174 */         }
/* 175 */         if (comp == 0) {
/* 176 */           comp = smj_value3.compare(smj_value15);
/* 177 */         }
/* 178 */         if (comp == 0) {
/* 179 */           comp = (smj_value4 > smj_value16 ? 1 : smj_value4 < smj_value16 ? -1 : 0);
/* 180 */         }
/* 181 */
/* 182 */         if (comp > 0) {
/* 183 */           smj_rightRow = null;
/* 184 */         } else if (comp < 0) {
/* 185 */           if (!smj_matches.isEmpty()) {
/* 186 */             smj_value17 = smj_value.clone();
/* 187 */             smj_value18 = smj_value1.clone();
/* 188 */             smj_value19 = smj_value2.clone();
/* 189 */             smj_value20 = smj_value3.clone();
/* 190 */             smj_value21 = smj_value4;
/* 191 */             return true;
/* 192 */           }
/* 193 */           smj_leftRow = null;
/* 194 */         } else {
/* 195 */           smj_matches.add((UnsafeRow) smj_rightRow);
/* 196 */           smj_rightRow = null;;
/* 197 */         }
/* 198 */       } while (smj_leftRow != null);
/* 199 */     }
/* 200 */     return false; // unreachable
/* 201 */   }
/* 202 */
/* 203 */   protected void processNext() throws java.io.IOException {
/* 204 */     while (findNextInnerJoinRows(smj_leftInput, smj_rightInput)) {
/* 205 */       smj_isNull12 = smj_leftRow.isNullAt(0);
/* 206 */       smj_value22 = smj_isNull12 ? null : (smj_leftRow.getUTF8String(0));
/* 207 */       smj_isNull13 = smj_leftRow.isNullAt(1);
/* 208 */       smj_value23 = smj_isNull13 ? null : (smj_leftRow.getUTF8String(1));
/* 209 */       smj_isNull14 = smj_leftRow.isNullAt(2);
/* 210 */       smj_value24 = smj_isNull14 ? null : (smj_leftRow.getUTF8String(2));
/* 211 */       smj_isNull15 = smj_leftRow.isNullAt(3);
/* 212 */       smj_value25 = smj_isNull15 ? null : (smj_leftRow.getUTF8String(3));
/* 213 */       smj_value26 = smj_leftRow.getInt(4);
/* 214 */       smj_isNull16 = smj_leftRow.isNullAt(5);
/* 215 */       smj_value27 = smj_isNull16 ? -1 : (smj_leftRow.getInt(5));
/* 216 */       smj_isNull17 = smj_leftRow.isNullAt(6);
/* 217 */       smj_value28 = smj_isNull17 ? -1.0 : (smj_leftRow.getDouble(6));
/* 218 */       smj_value29 = smj_leftRow.getDouble(7);
/* 219 */       smj_value30 = smj_leftRow.getInt(8);
/* 220 */       scala.collection.Iterator<UnsafeRow> smj_iterator = smj_matches.generateIterator();
/* 221 */       while (smj_iterator.hasNext()) {
/* 222 */         InternalRow smj_rightRow1 = (InternalRow) smj_iterator.next();
/* 223 */
/* 224 */         smj_numOutputRows.add(1);
/* 225 */
/* 226 */         boolean smj_isNull22 = smj_rightRow1.isNullAt(4);
/* 227 */         double smj_value35 = smj_isNull22 ? -1.0 : (smj_rightRow1.getDouble(4));
/* 228 */         project_holder.reset();
/* 229 */
/* 230 */         project_rowWriter.zeroOutNullBytes();
/* 231 */
/* 232 */         if (smj_isNull12) {
/* 233 */           project_rowWriter.setNullAt(0);
/* 234 */         } else {
/* 235 */           project_rowWriter.write(0, smj_value22);
/* 236 */         }
/* 237 */
/* 238 */         if (smj_isNull13) {
/* 239 */           project_rowWriter.setNullAt(1);
/* 240 */         } else {
/* 241 */           project_rowWriter.write(1, smj_value23);
/* 242 */         }
/* 243 */
/* 244 */         if (smj_isNull14) {
/* 245 */           project_rowWriter.setNullAt(2);
/* 246 */         } else {
/* 247 */           project_rowWriter.write(2, smj_value24);
/* 248 */         }
/* 249 */
/* 250 */         if (smj_isNull15) {
/* 251 */           project_rowWriter.setNullAt(3);
/* 252 */         } else {
/* 253 */           project_rowWriter.write(3, smj_value25);
/* 254 */         }
/* 255 */
/* 256 */         project_rowWriter.write(4, smj_value26);
/* 257 */
/* 258 */         if (smj_isNull16) {
/* 259 */           project_rowWriter.setNullAt(5);
/* 260 */         } else {
/* 261 */           project_rowWriter.write(5, smj_value27);
/* 262 */         }
/* 263 */
/* 264 */         if (smj_isNull17) {
/* 265 */           project_rowWriter.setNullAt(6);
/* 266 */         } else {
/* 267 */           project_rowWriter.write(6, smj_value28);
/* 268 */         }
/* 269 */
/* 270 */         project_rowWriter.write(7, smj_value29);
/* 271 */
/* 272 */         project_rowWriter.write(8, smj_value30);
/* 273 */
/* 274 */         if (smj_isNull22) {
/* 275 */           project_rowWriter.setNullAt(9);
/* 276 */         } else {
/* 277 */           project_rowWriter.write(9, smj_value35);
/* 278 */         }
/* 279 */         project_result.setTotalSize(project_holder.totalSize());
/* 280 */         append(project_result.copy());
/* 281 */
/* 282 */       }
/* 283 */       if (shouldStop()) return;
/* 284 */     }
/* 285 */   }
/* 286 */ }
