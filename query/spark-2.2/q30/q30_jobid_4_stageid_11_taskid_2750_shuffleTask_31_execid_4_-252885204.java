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
/* 012 */   private long smj_value3;
/* 013 */   private org.apache.spark.sql.execution.ExternalAppendOnlyUnsafeRowArray smj_matches;
/* 014 */   private long smj_value4;
/* 015 */   private long smj_value5;
/* 016 */   private boolean smj_isNull3;
/* 017 */   private double smj_value6;
/* 018 */   private boolean smj_isNull4;
/* 019 */   private org.apache.spark.sql.execution.metric.SQLMetric smj_numOutputRows;
/* 020 */   private UnsafeRow smj_result;
/* 021 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder smj_holder;
/* 022 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter smj_rowWriter;
/* 023 */   private UnsafeRow project_result;
/* 024 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 025 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 026 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast;
/* 027 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation;
/* 028 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows;
/* 029 */   private UnsafeRow bhj_result;
/* 030 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder;
/* 031 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter;
/* 032 */   private UnsafeRow project_result1;
/* 033 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder1;
/* 034 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter1;
/* 035 */
/* 036 */   public GeneratedIterator(Object[] references) {
/* 037 */     this.references = references;
/* 038 */   }
/* 039 */
/* 040 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 041 */     partitionIndex = index;
/* 042 */     this.inputs = inputs;
/* 043 */     wholestagecodegen_init_0();
/* 044 */     wholestagecodegen_init_1();
/* 045 */
/* 046 */   }
/* 047 */
/* 048 */   private void wholestagecodegen_init_0() {
/* 049 */     smj_leftInput = inputs[0];
/* 050 */     smj_rightInput = inputs[1];
/* 051 */
/* 052 */     smj_rightRow = null;
/* 053 */
/* 054 */     smj_matches = new org.apache.spark.sql.execution.ExternalAppendOnlyUnsafeRowArray(2147483647);
/* 055 */
/* 056 */     this.smj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[0];
/* 057 */     smj_result = new UnsafeRow(16);
/* 058 */     this.smj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(smj_result, 288);
/* 059 */     this.smj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(smj_holder, 16);
/* 060 */     project_result = new UnsafeRow(14);
/* 061 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 288);
/* 062 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 14);
/* 063 */     this.bhj_broadcast = (org.apache.spark.broadcast.TorrentBroadcast) references[1];
/* 064 */
/* 065 */     bhj_relation = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast.value()).asReadOnlyCopy();
/* 066 */     incPeakExecutionMemory(bhj_relation.estimatedSize());
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
/* 080 */       long smj_value = smj_isNull ? -1L : (smj_leftRow.getLong(0));
/* 081 */       if (smj_isNull) {
/* 082 */         smj_leftRow = null;
/* 083 */         continue;
/* 084 */       }
/* 085 */       if (!smj_matches.isEmpty()) {
/* 086 */         comp = 0;
/* 087 */         if (comp == 0) {
/* 088 */           comp = (smj_value > smj_value4 ? 1 : smj_value < smj_value4 ? -1 : 0);
/* 089 */         }
/* 090 */
/* 091 */         if (comp == 0) {
/* 092 */           return true;
/* 093 */         }
/* 094 */         smj_matches.clear();
/* 095 */       }
/* 096 */
/* 097 */       do {
/* 098 */         if (smj_rightRow == null) {
/* 099 */           if (!rightIter.hasNext()) {
/* 100 */             smj_value4 = smj_value;
/* 101 */             return !smj_matches.isEmpty();
/* 102 */           }
/* 103 */           smj_rightRow = (InternalRow) rightIter.next();
/* 104 */
/* 105 */           boolean smj_isNull2 = smj_rightRow.isNullAt(0);
/* 106 */           int smj_value2 = smj_isNull2 ? -1 : (smj_rightRow.getInt(0));
/* 107 */           boolean smj_isNull1 = smj_isNull2;
/* 108 */           long smj_value1 = -1L;
/* 109 */           if (!smj_isNull2) {
/* 110 */             smj_value1 = (long) smj_value2;
/* 111 */           }
/* 112 */           if (smj_isNull1) {
/* 113 */             smj_rightRow = null;
/* 114 */             continue;
/* 115 */           }
/* 116 */           smj_value3 = smj_value1;
/* 117 */         }
/* 118 */
/* 119 */         comp = 0;
/* 120 */         if (comp == 0) {
/* 121 */           comp = (smj_value > smj_value3 ? 1 : smj_value < smj_value3 ? -1 : 0);
/* 122 */         }
/* 123 */
/* 124 */         if (comp > 0) {
/* 125 */           smj_rightRow = null;
/* 126 */         } else if (comp < 0) {
/* 127 */           if (!smj_matches.isEmpty()) {
/* 128 */             smj_value4 = smj_value;
/* 129 */             return true;
/* 130 */           }
/* 131 */           smj_leftRow = null;
/* 132 */         } else {
/* 133 */           smj_matches.add((UnsafeRow) smj_rightRow);
/* 134 */           smj_rightRow = null;;
/* 135 */         }
/* 136 */       } while (smj_leftRow != null);
/* 137 */     }
/* 138 */     return false; // unreachable
/* 139 */   }
/* 140 */
/* 141 */   private void wholestagecodegen_init_1() {
/* 142 */     this.bhj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 143 */     bhj_result = new UnsafeRow(15);
/* 144 */     this.bhj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result, 288);
/* 145 */     this.bhj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder, 15);
/* 146 */     project_result1 = new UnsafeRow(13);
/* 147 */     this.project_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result1, 288);
/* 148 */     this.project_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder1, 13);
/* 149 */
/* 150 */   }
/* 151 */
/* 152 */   protected void processNext() throws java.io.IOException {
/* 153 */     while (findNextInnerJoinRows(smj_leftInput, smj_rightInput)) {
/* 154 */       smj_isNull3 = smj_leftRow.isNullAt(0);
/* 155 */       smj_value5 = smj_isNull3 ? -1L : (smj_leftRow.getLong(0));
/* 156 */       smj_isNull4 = smj_leftRow.isNullAt(1);
/* 157 */       smj_value6 = smj_isNull4 ? -1.0 : (smj_leftRow.getDouble(1));
/* 158 */       scala.collection.Iterator<UnsafeRow> smj_iterator = smj_matches.generateIterator();
/* 159 */       while (smj_iterator.hasNext()) {
/* 160 */         InternalRow smj_rightRow1 = (InternalRow) smj_iterator.next();
/* 161 */
/* 162 */         smj_numOutputRows.add(1);
/* 163 */
/* 164 */         boolean smj_isNull7 = smj_rightRow1.isNullAt(2);
/* 165 */         int smj_value9 = smj_isNull7 ? -1 : (smj_rightRow1.getInt(2));
/* 166 */
/* 167 */         // generate join key for stream side
/* 168 */
/* 169 */         boolean bhj_isNull = smj_isNull7;
/* 170 */         long bhj_value = -1L;
/* 171 */         if (!smj_isNull7) {
/* 172 */           bhj_value = (long) smj_value9;
/* 173 */         }
/* 174 */         // find matches from HashedRelation
/* 175 */         UnsafeRow bhj_matched = bhj_isNull ? null: (UnsafeRow)bhj_relation.getValue(bhj_value);
/* 176 */         if (bhj_matched == null) continue;
/* 177 */
/* 178 */         bhj_numOutputRows.add(1);
/* 179 */
/* 180 */         boolean smj_isNull6 = smj_rightRow1.isNullAt(1);
/* 181 */         UTF8String smj_value8 = smj_isNull6 ? null : (smj_rightRow1.getUTF8String(1));
/* 182 */         boolean smj_isNull8 = smj_rightRow1.isNullAt(3);
/* 183 */         UTF8String smj_value10 = smj_isNull8 ? null : (smj_rightRow1.getUTF8String(3));
/* 184 */         boolean smj_isNull9 = smj_rightRow1.isNullAt(4);
/* 185 */         UTF8String smj_value11 = smj_isNull9 ? null : (smj_rightRow1.getUTF8String(4));
/* 186 */         boolean smj_isNull10 = smj_rightRow1.isNullAt(5);
/* 187 */         UTF8String smj_value12 = smj_isNull10 ? null : (smj_rightRow1.getUTF8String(5));
/* 188 */         boolean smj_isNull11 = smj_rightRow1.isNullAt(6);
/* 189 */         UTF8String smj_value13 = smj_isNull11 ? null : (smj_rightRow1.getUTF8String(6));
/* 190 */         boolean smj_isNull12 = smj_rightRow1.isNullAt(7);
/* 191 */         int smj_value14 = smj_isNull12 ? -1 : (smj_rightRow1.getInt(7));
/* 192 */         boolean smj_isNull13 = smj_rightRow1.isNullAt(8);
/* 193 */         int smj_value15 = smj_isNull13 ? -1 : (smj_rightRow1.getInt(8));
/* 194 */         boolean smj_isNull14 = smj_rightRow1.isNullAt(9);
/* 195 */         int smj_value16 = smj_isNull14 ? -1 : (smj_rightRow1.getInt(9));
/* 196 */         boolean smj_isNull15 = smj_rightRow1.isNullAt(10);
/* 197 */         UTF8String smj_value17 = smj_isNull15 ? null : (smj_rightRow1.getUTF8String(10));
/* 198 */         boolean smj_isNull16 = smj_rightRow1.isNullAt(11);
/* 199 */         UTF8String smj_value18 = smj_isNull16 ? null : (smj_rightRow1.getUTF8String(11));
/* 200 */         boolean smj_isNull17 = smj_rightRow1.isNullAt(12);
/* 201 */         UTF8String smj_value19 = smj_isNull17 ? null : (smj_rightRow1.getUTF8String(12));
/* 202 */         boolean smj_isNull18 = smj_rightRow1.isNullAt(13);
/* 203 */         UTF8String smj_value20 = smj_isNull18 ? null : (smj_rightRow1.getUTF8String(13));
/* 204 */         project_holder1.reset();
/* 205 */
/* 206 */         project_rowWriter1.zeroOutNullBytes();
/* 207 */
/* 208 */         if (smj_isNull6) {
/* 209 */           project_rowWriter1.setNullAt(0);
/* 210 */         } else {
/* 211 */           project_rowWriter1.write(0, smj_value8);
/* 212 */         }
/* 213 */
/* 214 */         if (smj_isNull8) {
/* 215 */           project_rowWriter1.setNullAt(1);
/* 216 */         } else {
/* 217 */           project_rowWriter1.write(1, smj_value10);
/* 218 */         }
/* 219 */
/* 220 */         if (smj_isNull9) {
/* 221 */           project_rowWriter1.setNullAt(2);
/* 222 */         } else {
/* 223 */           project_rowWriter1.write(2, smj_value11);
/* 224 */         }
/* 225 */
/* 226 */         if (smj_isNull10) {
/* 227 */           project_rowWriter1.setNullAt(3);
/* 228 */         } else {
/* 229 */           project_rowWriter1.write(3, smj_value12);
/* 230 */         }
/* 231 */
/* 232 */         if (smj_isNull11) {
/* 233 */           project_rowWriter1.setNullAt(4);
/* 234 */         } else {
/* 235 */           project_rowWriter1.write(4, smj_value13);
/* 236 */         }
/* 237 */
/* 238 */         if (smj_isNull12) {
/* 239 */           project_rowWriter1.setNullAt(5);
/* 240 */         } else {
/* 241 */           project_rowWriter1.write(5, smj_value14);
/* 242 */         }
/* 243 */
/* 244 */         if (smj_isNull13) {
/* 245 */           project_rowWriter1.setNullAt(6);
/* 246 */         } else {
/* 247 */           project_rowWriter1.write(6, smj_value15);
/* 248 */         }
/* 249 */
/* 250 */         if (smj_isNull14) {
/* 251 */           project_rowWriter1.setNullAt(7);
/* 252 */         } else {
/* 253 */           project_rowWriter1.write(7, smj_value16);
/* 254 */         }
/* 255 */
/* 256 */         if (smj_isNull15) {
/* 257 */           project_rowWriter1.setNullAt(8);
/* 258 */         } else {
/* 259 */           project_rowWriter1.write(8, smj_value17);
/* 260 */         }
/* 261 */
/* 262 */         if (smj_isNull16) {
/* 263 */           project_rowWriter1.setNullAt(9);
/* 264 */         } else {
/* 265 */           project_rowWriter1.write(9, smj_value18);
/* 266 */         }
/* 267 */
/* 268 */         if (smj_isNull17) {
/* 269 */           project_rowWriter1.setNullAt(10);
/* 270 */         } else {
/* 271 */           project_rowWriter1.write(10, smj_value19);
/* 272 */         }
/* 273 */
/* 274 */         if (smj_isNull18) {
/* 275 */           project_rowWriter1.setNullAt(11);
/* 276 */         } else {
/* 277 */           project_rowWriter1.write(11, smj_value20);
/* 278 */         }
/* 279 */
/* 280 */         if (smj_isNull4) {
/* 281 */           project_rowWriter1.setNullAt(12);
/* 282 */         } else {
/* 283 */           project_rowWriter1.write(12, smj_value6);
/* 284 */         }
/* 285 */         project_result1.setTotalSize(project_holder1.totalSize());
/* 286 */         append(project_result1.copy());
/* 287 */
/* 288 */       }
/* 289 */       if (shouldStop()) return;
/* 290 */     }
/* 291 */   }
/* 292 */ }
