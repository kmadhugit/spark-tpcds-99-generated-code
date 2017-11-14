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
/* 029 */
/* 030 */   public GeneratedIterator(Object[] references) {
/* 031 */     this.references = references;
/* 032 */   }
/* 033 */
/* 034 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 035 */     partitionIndex = index;
/* 036 */     this.inputs = inputs;
/* 037 */     wholestagecodegen_init_0();
/* 038 */     wholestagecodegen_init_1();
/* 039 */
/* 040 */   }
/* 041 */
/* 042 */   private void wholestagecodegen_init_0() {
/* 043 */     scan_input = inputs[0];
/* 044 */     this.scan_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[0];
/* 045 */     this.scan_scanTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 046 */     scan_scanTime1 = 0;
/* 047 */     scan_batch = null;
/* 048 */     scan_batchIdx = 0;
/* 049 */     scan_colInstance0 = null;
/* 050 */     scan_colInstance1 = null;
/* 051 */     scan_colInstance2 = null;
/* 052 */     scan_colInstance3 = null;
/* 053 */     scan_colInstance4 = null;
/* 054 */     scan_result = new UnsafeRow(5);
/* 055 */     this.scan_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(scan_result, 0);
/* 056 */     this.scan_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(scan_holder, 5);
/* 057 */     this.filter_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 058 */     filter_result = new UnsafeRow(5);
/* 059 */     this.filter_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(filter_result, 0);
/* 060 */     this.filter_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(filter_holder, 5);
/* 061 */     project_result = new UnsafeRow(4);
/* 062 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 0);
/* 063 */
/* 064 */   }
/* 065 */
/* 066 */   private void scan_nextBatch() throws java.io.IOException {
/* 067 */     long getBatchStart = System.nanoTime();
/* 068 */     if (scan_input.hasNext()) {
/* 069 */       scan_batch = (org.apache.spark.sql.execution.vectorized.ColumnarBatch)scan_input.next();
/* 070 */       scan_numOutputRows.add(scan_batch.numRows());
/* 071 */       scan_batchIdx = 0;
/* 072 */       scan_colInstance0 = scan_batch.column(0);
/* 073 */       scan_colInstance1 = scan_batch.column(1);
/* 074 */       scan_colInstance2 = scan_batch.column(2);
/* 075 */       scan_colInstance3 = scan_batch.column(3);
/* 076 */       scan_colInstance4 = scan_batch.column(4);
/* 077 */
/* 078 */     }
/* 079 */     scan_scanTime1 += System.nanoTime() - getBatchStart;
/* 080 */   }
/* 081 */
/* 082 */   private void wholestagecodegen_init_1() {
/* 083 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 4);
/* 084 */
/* 085 */   }
/* 086 */
/* 087 */   protected void processNext() throws java.io.IOException {
/* 088 */     if (scan_batch == null) {
/* 089 */       scan_nextBatch();
/* 090 */     }
/* 091 */     while (scan_batch != null) {
/* 092 */       int numRows = scan_batch.numRows();
/* 093 */       while (scan_batchIdx < numRows) {
/* 094 */         int scan_rowIdx = scan_batchIdx++;
/* 095 */         boolean scan_isNull3 = scan_colInstance3.isNullAt(scan_rowIdx);
/* 096 */         int scan_value3 = scan_isNull3 ? -1 : (scan_colInstance3.getInt(scan_rowIdx));
/* 097 */
/* 098 */         boolean filter_value = false;
/* 099 */         boolean filter_isNull = scan_isNull3;
/* 100 */         if (!filter_isNull) {
/* 101 */           if (!filter_value) {
/* 102 */             if (false) {
/* 103 */               filter_isNull = true;
/* 104 */             } else if (scan_value3 == 1) {
/* 105 */               filter_isNull = false;
/* 106 */               filter_value = true;
/* 107 */             }
/* 108 */           }
/* 109 */
/* 110 */           if (!filter_value) {
/* 111 */             if (false) {
/* 112 */               filter_isNull = true;
/* 113 */             } else if (scan_value3 == 6) {
/* 114 */               filter_isNull = false;
/* 115 */               filter_value = true;
/* 116 */             }
/* 117 */           }
/* 118 */
/* 119 */           if (!filter_value) {
/* 120 */             if (false) {
/* 121 */               filter_isNull = true;
/* 122 */             } else if (scan_value3 == 8) {
/* 123 */               filter_isNull = false;
/* 124 */               filter_value = true;
/* 125 */             }
/* 126 */           }
/* 127 */
/* 128 */           if (!filter_value) {
/* 129 */             if (false) {
/* 130 */               filter_isNull = true;
/* 131 */             } else if (scan_value3 == 9) {
/* 132 */               filter_isNull = false;
/* 133 */               filter_value = true;
/* 134 */             }
/* 135 */           }
/* 136 */
/* 137 */           if (!filter_value) {
/* 138 */             if (false) {
/* 139 */               filter_isNull = true;
/* 140 */             } else if (scan_value3 == 12) {
/* 141 */               filter_isNull = false;
/* 142 */               filter_value = true;
/* 143 */             }
/* 144 */           }
/* 145 */
/* 146 */           if (!filter_value) {
/* 147 */             if (false) {
/* 148 */               filter_isNull = true;
/* 149 */             } else if (scan_value3 == 2) {
/* 150 */               filter_isNull = false;
/* 151 */               filter_value = true;
/* 152 */             }
/* 153 */           }
/* 154 */
/* 155 */         }
/* 156 */         if (filter_isNull || !filter_value) continue;
/* 157 */
/* 158 */         boolean scan_isNull = scan_colInstance0.isNullAt(scan_rowIdx);
/* 159 */         int scan_value = scan_isNull ? -1 : (scan_colInstance0.getInt(scan_rowIdx));
/* 160 */
/* 161 */         if (!(!(scan_isNull))) continue;
/* 162 */
/* 163 */         boolean scan_isNull1 = scan_colInstance1.isNullAt(scan_rowIdx);
/* 164 */         int scan_value1 = scan_isNull1 ? -1 : (scan_colInstance1.getInt(scan_rowIdx));
/* 165 */
/* 166 */         if (!(!(scan_isNull1))) continue;
/* 167 */
/* 168 */         boolean scan_isNull2 = scan_colInstance2.isNullAt(scan_rowIdx);
/* 169 */         int scan_value2 = scan_isNull2 ? -1 : (scan_colInstance2.getInt(scan_rowIdx));
/* 170 */
/* 171 */         if (!(!(scan_isNull2))) continue;
/* 172 */
/* 173 */         filter_numOutputRows.add(1);
/* 174 */
/* 175 */         boolean scan_isNull4 = scan_colInstance4.isNullAt(scan_rowIdx);
/* 176 */         int scan_value4 = scan_isNull4 ? -1 : (scan_colInstance4.getInt(scan_rowIdx));
/* 177 */         project_rowWriter.zeroOutNullBytes();
/* 178 */
/* 179 */         project_rowWriter.write(0, scan_value);
/* 180 */
/* 181 */         project_rowWriter.write(1, scan_value1);
/* 182 */
/* 183 */         project_rowWriter.write(2, scan_value2);
/* 184 */
/* 185 */         if (scan_isNull4) {
/* 186 */           project_rowWriter.setNullAt(3);
/* 187 */         } else {
/* 188 */           project_rowWriter.write(3, scan_value4);
/* 189 */         }
/* 190 */         append(project_result);
/* 191 */         if (shouldStop()) return;
/* 192 */       }
/* 193 */       scan_batch = null;
/* 194 */       scan_nextBatch();
/* 195 */     }
/* 196 */     scan_scanTime.add(scan_scanTime1 / (1000 * 1000));
/* 197 */     scan_scanTime1 = 0;
/* 198 */   }
/* 199 */ }
