/* 001 */ public Object generate(Object[] references) {
/* 002 */   return new GeneratedIterator(references);
/* 003 */ }
/* 004 */
/* 005 */ final class GeneratedIterator extends org.apache.spark.sql.execution.BufferedRowIterator {
/* 006 */   private Object[] references;
/* 007 */   private scala.collection.Iterator[] inputs;
/* 008 */   private scala.collection.Iterator scan_input;
/* 009 */   private org.apache.spark.sql.execution.metric.SQLMetric scan_numOutputRows;
/* 010 */   private org.apache.spark.sql.execution.metric.SQLMetric scan_scanTime;
/* 011 */   private long scan_scanTime1;
/* 012 */   private org.apache.spark.sql.execution.vectorized.ColumnarBatch scan_batch;
/* 013 */   private int scan_batchIdx;
/* 014 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance0;
/* 015 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance1;
/* 016 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance2;
/* 017 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance3;
/* 018 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance4;
/* 019 */   private UnsafeRow scan_result;
/* 020 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder scan_holder;
/* 021 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter scan_rowWriter;
/* 022 */   private org.apache.spark.sql.execution.metric.SQLMetric filter_numOutputRows;
/* 023 */   private UnsafeRow filter_result;
/* 024 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder filter_holder;
/* 025 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter filter_rowWriter;
/* 026 */   private UnsafeRow project_result;
/* 027 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 028 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 029 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast;
/* 030 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation;
/* 031 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows;
/* 032 */   private UnsafeRow bhj_result;
/* 033 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder;
/* 034 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter;
/* 035 */   private UnsafeRow project_result1;
/* 036 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder1;
/* 037 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter1;
/* 038 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast1;
/* 039 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation1;
/* 040 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows1;
/* 041 */   private UnsafeRow bhj_result1;
/* 042 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder1;
/* 043 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter1;
/* 044 */   private UnsafeRow project_result2;
/* 045 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder2;
/* 046 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter2;
/* 047 */
/* 048 */   public GeneratedIterator(Object[] references) {
/* 049 */     this.references = references;
/* 050 */   }
/* 051 */
/* 052 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 053 */     partitionIndex = index;
/* 054 */     this.inputs = inputs;
/* 055 */     wholestagecodegen_init_0();
/* 056 */     wholestagecodegen_init_1();
/* 057 */     wholestagecodegen_init_2();
/* 058 */
/* 059 */   }
/* 060 */
/* 061 */   private void wholestagecodegen_init_0() {
/* 062 */     scan_input = inputs[0];
/* 063 */     this.scan_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[0];
/* 064 */     this.scan_scanTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 065 */     scan_scanTime1 = 0;
/* 066 */     scan_batch = null;
/* 067 */     scan_batchIdx = 0;
/* 068 */     scan_colInstance0 = null;
/* 069 */     scan_colInstance1 = null;
/* 070 */     scan_colInstance2 = null;
/* 071 */     scan_colInstance3 = null;
/* 072 */     scan_colInstance4 = null;
/* 073 */     scan_result = new UnsafeRow(5);
/* 074 */     this.scan_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(scan_result, 64);
/* 075 */     this.scan_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(scan_holder, 5);
/* 076 */     this.filter_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 077 */     filter_result = new UnsafeRow(5);
/* 078 */     this.filter_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(filter_result, 64);
/* 079 */     this.filter_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(filter_holder, 5);
/* 080 */     project_result = new UnsafeRow(4);
/* 081 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 64);
/* 082 */
/* 083 */   }
/* 084 */
/* 085 */   private void scan_nextBatch() throws java.io.IOException {
/* 086 */     long getBatchStart = System.nanoTime();
/* 087 */     if (scan_input.hasNext()) {
/* 088 */       scan_batch = (org.apache.spark.sql.execution.vectorized.ColumnarBatch)scan_input.next();
/* 089 */       scan_numOutputRows.add(scan_batch.numRows());
/* 090 */       scan_batchIdx = 0;
/* 091 */       scan_colInstance0 = scan_batch.column(0);
/* 092 */       scan_colInstance1 = scan_batch.column(1);
/* 093 */       scan_colInstance2 = scan_batch.column(2);
/* 094 */       scan_colInstance3 = scan_batch.column(3);
/* 095 */       scan_colInstance4 = scan_batch.column(4);
/* 096 */
/* 097 */     }
/* 098 */     scan_scanTime1 += System.nanoTime() - getBatchStart;
/* 099 */   }
/* 100 */
/* 101 */   private void wholestagecodegen_init_2() {
/* 102 */     bhj_relation1 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast1.value()).asReadOnlyCopy();
/* 103 */     incPeakExecutionMemory(bhj_relation1.estimatedSize());
/* 104 */
/* 105 */     this.bhj_numOutputRows1 = (org.apache.spark.sql.execution.metric.SQLMetric) references[6];
/* 106 */     bhj_result1 = new UnsafeRow(6);
/* 107 */     this.bhj_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result1, 64);
/* 108 */     this.bhj_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder1, 6);
/* 109 */     project_result2 = new UnsafeRow(4);
/* 110 */     this.project_holder2 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result2, 64);
/* 111 */     this.project_rowWriter2 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder2, 4);
/* 112 */
/* 113 */   }
/* 114 */
/* 115 */   private void wholestagecodegen_init_1() {
/* 116 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 4);
/* 117 */     this.bhj_broadcast = (org.apache.spark.broadcast.TorrentBroadcast) references[3];
/* 118 */
/* 119 */     bhj_relation = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast.value()).asReadOnlyCopy();
/* 120 */     incPeakExecutionMemory(bhj_relation.estimatedSize());
/* 121 */
/* 122 */     this.bhj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[4];
/* 123 */     bhj_result = new UnsafeRow(6);
/* 124 */     this.bhj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result, 64);
/* 125 */     this.bhj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder, 6);
/* 126 */     project_result1 = new UnsafeRow(5);
/* 127 */     this.project_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result1, 64);
/* 128 */     this.project_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder1, 5);
/* 129 */     this.bhj_broadcast1 = (org.apache.spark.broadcast.TorrentBroadcast) references[5];
/* 130 */
/* 131 */   }
/* 132 */
/* 133 */   protected void processNext() throws java.io.IOException {
/* 134 */     if (scan_batch == null) {
/* 135 */       scan_nextBatch();
/* 136 */     }
/* 137 */     while (scan_batch != null) {
/* 138 */       int numRows = scan_batch.numRows();
/* 139 */       while (scan_batchIdx < numRows) {
/* 140 */         int scan_rowIdx = scan_batchIdx++;
/* 141 */         boolean scan_isNull3 = scan_colInstance3.isNullAt(scan_rowIdx);
/* 142 */         double scan_value3 = scan_isNull3 ? -1.0 : (scan_colInstance3.getDouble(scan_rowIdx));
/* 143 */
/* 144 */         if (!(!(scan_isNull3))) continue;
/* 145 */
/* 146 */         boolean filter_isNull2 = false;
/* 147 */
/* 148 */         boolean filter_value2 = false;
/* 149 */         filter_value2 = org.apache.spark.util.Utils.nanSafeCompareDoubles(scan_value3, 68.0D) >= 0;
/* 150 */         if (!filter_value2) continue;
/* 151 */         boolean filter_isNull5 = false;
/* 152 */
/* 153 */         boolean filter_value5 = false;
/* 154 */         filter_value5 = org.apache.spark.util.Utils.nanSafeCompareDoubles(scan_value3, 98.0D) <= 0;
/* 155 */         if (!filter_value5) continue;
/* 156 */         boolean scan_isNull4 = scan_colInstance4.isNullAt(scan_rowIdx);
/* 157 */         int scan_value4 = scan_isNull4 ? -1 : (scan_colInstance4.getInt(scan_rowIdx));
/* 158 */
/* 159 */         boolean filter_value8 = false;
/* 160 */         boolean filter_isNull8 = scan_isNull4;
/* 161 */         if (!filter_isNull8) {
/* 162 */           if (!filter_value8) {
/* 163 */             if (false) {
/* 164 */               filter_isNull8 = true;
/* 165 */             } else if (scan_value4 == 677) {
/* 166 */               filter_isNull8 = false;
/* 167 */               filter_value8 = true;
/* 168 */             }
/* 169 */           }
/* 170 */
/* 171 */           if (!filter_value8) {
/* 172 */             if (false) {
/* 173 */               filter_isNull8 = true;
/* 174 */             } else if (scan_value4 == 940) {
/* 175 */               filter_isNull8 = false;
/* 176 */               filter_value8 = true;
/* 177 */             }
/* 178 */           }
/* 179 */
/* 180 */           if (!filter_value8) {
/* 181 */             if (false) {
/* 182 */               filter_isNull8 = true;
/* 183 */             } else if (scan_value4 == 694) {
/* 184 */               filter_isNull8 = false;
/* 185 */               filter_value8 = true;
/* 186 */             }
/* 187 */           }
/* 188 */
/* 189 */           if (!filter_value8) {
/* 190 */             if (false) {
/* 191 */               filter_isNull8 = true;
/* 192 */             } else if (scan_value4 == 808) {
/* 193 */               filter_isNull8 = false;
/* 194 */               filter_value8 = true;
/* 195 */             }
/* 196 */           }
/* 197 */
/* 198 */         }
/* 199 */         if (filter_isNull8 || !filter_value8) continue;
/* 200 */
/* 201 */         boolean scan_isNull = scan_colInstance0.isNullAt(scan_rowIdx);
/* 202 */         int scan_value = scan_isNull ? -1 : (scan_colInstance0.getInt(scan_rowIdx));
/* 203 */
/* 204 */         if (!(!(scan_isNull))) continue;
/* 205 */
/* 206 */         filter_numOutputRows.add(1);
/* 207 */
/* 208 */         // generate join key for stream side
/* 209 */
/* 210 */         boolean bhj_isNull = false;
/* 211 */         long bhj_value = -1L;
/* 212 */         if (!false) {
/* 213 */           bhj_value = (long) scan_value;
/* 214 */         }
/* 215 */         // find matches from HashedRelation
/* 216 */         UnsafeRow bhj_matched = bhj_isNull ? null: (UnsafeRow)bhj_relation.getValue(bhj_value);
/* 217 */         if (bhj_matched == null) continue;
/* 218 */
/* 219 */         bhj_numOutputRows.add(1);
/* 220 */
/* 221 */         boolean bhj_isNull3 = bhj_matched.isNullAt(1);
/* 222 */         int bhj_value3 = bhj_isNull3 ? -1 : (bhj_matched.getInt(1));
/* 223 */
/* 224 */         // generate join key for stream side
/* 225 */
/* 226 */         boolean bhj_isNull10 = bhj_isNull3;
/* 227 */         long bhj_value10 = -1L;
/* 228 */         if (!bhj_isNull3) {
/* 229 */           bhj_value10 = (long) bhj_value3;
/* 230 */         }
/* 231 */         // find matches from HashedRelation
/* 232 */         UnsafeRow bhj_matched1 = bhj_isNull10 ? null: (UnsafeRow)bhj_relation1.getValue(bhj_value10);
/* 233 */         if (bhj_matched1 == null) continue;
/* 234 */
/* 235 */         bhj_numOutputRows1.add(1);
/* 236 */
/* 237 */         boolean scan_isNull1 = scan_colInstance1.isNullAt(scan_rowIdx);
/* 238 */         UTF8String scan_value1 = scan_isNull1 ? null : (scan_colInstance1.getUTF8String(scan_rowIdx));
/* 239 */         boolean scan_isNull2 = scan_colInstance2.isNullAt(scan_rowIdx);
/* 240 */         UTF8String scan_value2 = scan_isNull2 ? null : (scan_colInstance2.getUTF8String(scan_rowIdx));
/* 241 */         project_holder2.reset();
/* 242 */
/* 243 */         project_rowWriter2.zeroOutNullBytes();
/* 244 */
/* 245 */         project_rowWriter2.write(0, scan_value);
/* 246 */
/* 247 */         if (scan_isNull1) {
/* 248 */           project_rowWriter2.setNullAt(1);
/* 249 */         } else {
/* 250 */           project_rowWriter2.write(1, scan_value1);
/* 251 */         }
/* 252 */
/* 253 */         if (scan_isNull2) {
/* 254 */           project_rowWriter2.setNullAt(2);
/* 255 */         } else {
/* 256 */           project_rowWriter2.write(2, scan_value2);
/* 257 */         }
/* 258 */
/* 259 */         project_rowWriter2.write(3, scan_value3);
/* 260 */         project_result2.setTotalSize(project_holder2.totalSize());
/* 261 */         append(project_result2);
/* 262 */         if (shouldStop()) return;
/* 263 */       }
/* 264 */       scan_batch = null;
/* 265 */       scan_nextBatch();
/* 266 */     }
/* 267 */     scan_scanTime.add(scan_scanTime1 / (1000 * 1000));
/* 268 */     scan_scanTime1 = 0;
/* 269 */   }
/* 270 */ }
